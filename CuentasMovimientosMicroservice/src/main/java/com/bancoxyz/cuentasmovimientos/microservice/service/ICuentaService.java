/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.service;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;

import java.util.List;
import java.util.Optional;

public interface ICuentaService {

    public Cuenta save(Cuenta cuenta);
    public void delete(Long id);
    public List<Cuenta> getAll();
    public Optional<Cuenta> getCuentaById(Long id);
}
