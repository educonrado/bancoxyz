/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.clientepersona.microservice.service;

import com.bancoxyz.clientepersona.microservice.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public Cliente save(Cliente cliente);
    public void delete(Long id);
    public List<Cliente> getAll();
    public Optional<Cliente> getClienteById(Long id);

}
