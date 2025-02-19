/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.controller;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;
import com.bancoxyz.cuentasmovimientos.microservice.entity.Movimiento;
import com.bancoxyz.cuentasmovimientos.microservice.service.ICuentaService;
import com.bancoxyz.cuentasmovimientos.microservice.service.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private IMovimientoService movimientoService;

    @Autowired
    private ICuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Movimiento>> getAll() {
        try {
            return new ResponseEntity<>(movimientoService.getAll(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento) {
        try {
            return new ResponseEntity<>(movimientoService.save(movimiento), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        try {
            Optional<Movimiento> cuenta = movimientoService.getMovimientoById(id);

            if (cuenta.isPresent()) {
                movimientoService.delete(id);
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
    public ResponseEntity<Movimiento> update(@RequestBody Movimiento movimiento) {
        try {
            if (Objects.isNull(movimiento)) {
                return ResponseEntity.badRequest().build();
            }
            Optional<Movimiento> movimientoTmp = movimientoService.getMovimientoById(movimiento.getId());
            if (movimientoTmp.isPresent()) {
                return new ResponseEntity<>(movimientoService.save(movimiento), HttpStatus.OK);
            }

            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
