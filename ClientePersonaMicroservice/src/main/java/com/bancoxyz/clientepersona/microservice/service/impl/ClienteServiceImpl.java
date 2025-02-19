/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.clientepersona.microservice.service.impl;

import com.bancoxyz.clientepersona.microservice.entity.Cliente;
import com.bancoxyz.clientepersona.microservice.repository.IClienteRepository;
import com.bancoxyz.clientepersona.microservice.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteServiceImpl implements IClienteService {

    private static final Logger LOGGER = Logger.getLogger("ClienteServiceImpl");
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al guardar cliente. %s", e));
            throw new RuntimeException("Error al guardar cliente", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            clienteRepository.deleteById(id);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al eliminar cliente. %s", e));
            throw new RuntimeException("Error al eliminar cliente", e);
        }
    }

    @Override
    public List<Cliente> getAll() {
        try {
            return clienteRepository.findAll();
        } catch (Exception e) {
            LOGGER.severe(String.format("No se puede obtener listado de clientes. %s", e));
            throw new RuntimeException("Error al obtener listado de clientes", e);
        }
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        try {
            return clienteRepository.findById(id);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al obtener cliente por id. %s", e));
            throw new RuntimeException("Error al obtener cliente por id", e);
        }
    }
}
