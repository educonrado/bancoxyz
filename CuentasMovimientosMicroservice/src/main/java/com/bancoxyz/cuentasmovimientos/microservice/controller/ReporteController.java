/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.controller;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;
import com.bancoxyz.cuentasmovimientos.microservice.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ICuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> getReport(@RequestParam(value = "nombre") String nombre,
                                                 @RequestParam(value = "inicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
                                                 @RequestParam(value = "fin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fin) {
        return new ResponseEntity<>(cuentaService.reporteEstadoCuenta(nombre, inicio, fin), HttpStatus.OK);
    }
}
