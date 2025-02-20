package com.bancoxyz.cuentasmovimientos.microservice.service;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Movimiento;
import com.bancoxyz.cuentasmovimientos.microservice.exception.SaldoException;

import java.util.List;
import java.util.Optional;

public interface IMovimientoService {

    public Movimiento save(Movimiento movimiento) throws SaldoException;
    public void delete(Long id);
    public List<Movimiento> getAll();
    public Optional<Movimiento> getMovimientoById(Long id);
}
