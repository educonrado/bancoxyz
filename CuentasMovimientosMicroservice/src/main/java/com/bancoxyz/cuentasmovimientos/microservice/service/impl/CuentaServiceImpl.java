/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.service.impl;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;
import com.bancoxyz.cuentasmovimientos.microservice.repository.ICuentaRepository;
import com.bancoxyz.cuentasmovimientos.microservice.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CuentaServiceImpl implements ICuentaService {

    private static final Logger LOGGER = Logger.getLogger("CuentaServiceImpl");

    @Autowired
    private ICuentaRepository cuentaRepository;

    /**
     * TODO: Crear lógica de creación de números de cuenta para que no sea un valor pasado sino autogenerado.
     *
     * @param cuenta
     * @return
     */
    @Override
    public Cuenta save(Cuenta cuenta) {
        try {
            return cuentaRepository.save(cuenta);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al guardar cuenta. %s", e));
            throw new RuntimeException("Error al guardar cuenta", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            cuentaRepository.deleteById(id);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al eliminar cuenta. %s", e));
            throw new RuntimeException("Error al eliminar cuenta", e);
        }
    }

    @Override
    public List<Cuenta> getAll() {
        try {
            return cuentaRepository.findAll();
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al obtener cuentas. %s", e));
            throw new RuntimeException("Error al obtener cuentas", e);
        }
    }

    @Override
    public Optional<Cuenta> getCuentaById(Long id) {
        try {
            return cuentaRepository.findById(id);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al buscar cuenta por id. %s", e));
            throw new RuntimeException("Error al buscar cuenta por id", e);
        }
    }

    @Override
    public List<Cuenta> reporteEstadoCuenta(String nombreCliente, LocalDate fechaInicio, LocalDate fechaFin) {
        try {
            return cuentaRepository.reporteEstadoCuenta(nombreCliente, fechaInicio, fechaFin);
        } catch (Exception e) {
            LOGGER.severe(String.format("No se puede generar el reporte solicitad. %s", e));
            throw new RuntimeException("No se puede generar el reporte solicitad", e);
        }

    }
}
