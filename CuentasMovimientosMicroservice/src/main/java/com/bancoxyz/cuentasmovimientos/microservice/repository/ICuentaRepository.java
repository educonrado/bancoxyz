/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.repository;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {

    @Query(value = "select c from Cuenta c JOIN c.movimientos m where c.cliente = :nombreCliente and m.fecha between :fechaInicio and :fechaFin")
    public List<Cuenta> reporteEstadoCuenta(String nombreCliente, LocalDate fechaInicio, LocalDate fechaFin);
}
