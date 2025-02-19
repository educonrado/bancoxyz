/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.clientepersona.microservice.controller;

import com.bancoxyz.clientepersona.microservice.entity.Cliente;
import com.bancoxyz.clientepersona.microservice.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        try {
            return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        try {
            return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        try {
            Optional<Cliente> cliente = clienteService.getClienteById(id);

            if (cliente.isPresent()) {
                clienteService.delete(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //TODO: Validaciones específicas de actualización
    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        try {
            if (Objects.isNull(cliente)) {
                return ResponseEntity.badRequest().build();
            }
            System.out.println(cliente.toString() + cliente.getId());
            Optional<Cliente> clienteTmp = clienteService.getClienteById(cliente.getId());
            if (clienteTmp.isPresent()) {
                return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.OK);
            }

            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
