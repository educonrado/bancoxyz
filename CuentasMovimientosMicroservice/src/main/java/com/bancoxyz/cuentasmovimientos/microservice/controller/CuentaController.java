/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.controller;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;
import com.bancoxyz.cuentasmovimientos.microservice.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private ICuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> getAll() {
        try {
            return new ResponseEntity<>(cuentaService.getAll(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta) {
        try {
            return new ResponseEntity<>(cuentaService.save(cuenta), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        try {
            Optional<Cuenta> cuenta = cuentaService.getCuentaById(id);

            if (cuenta.isPresent()) {
                cuentaService.delete(id);
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
    public ResponseEntity<Cuenta> update(@RequestBody Cuenta cuenta) {
        try {
            if (Objects.isNull(cuenta)) {
                return ResponseEntity.badRequest().build();
            }
            Optional<Cuenta> clienteTmp = cuentaService.getCuentaById(cuenta.getId());
            if (clienteTmp.isPresent()) {
                return new ResponseEntity<>(cuentaService.save(cuenta), HttpStatus.OK);
            }

            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
