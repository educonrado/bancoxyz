package com.bancoxyz.cuentasmovimientos.microservice.service.impl;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;
import com.bancoxyz.cuentasmovimientos.microservice.entity.Movimiento;
import com.bancoxyz.cuentasmovimientos.microservice.repository.IMovimientoRepository;
import com.bancoxyz.cuentasmovimientos.microservice.service.ICuentaService;
import com.bancoxyz.cuentasmovimientos.microservice.service.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

    private static final Logger LOGGER = Logger.getLogger("MovimientoServiceImpl");
    @Autowired
    private IMovimientoRepository movimientoRepository;
    @Autowired
    private ICuentaService cuentaService;

    @Override
    public Movimiento save(Movimiento movimiento) {
        try {
            actualizarSaldoDisponible(movimiento);
            return movimientoRepository.save(movimiento);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al guardar movimiento. %s", e));
            throw new RuntimeException("Error al guardar movimiento", e);
        }
    }

    private void actualizarSaldoDisponible(Movimiento movimiento) {
        Cuenta cuenta = movimiento.getCuenta();
        Optional<Cuenta> cuentaOpt = cuentaService.getCuentaById(cuenta.getId());
        if (cuentaOpt.isPresent()) {
            cuenta = cuentaOpt.get();
            Double saldoDisponibleActualizar = Double.sum(cuenta.getSaldoInicial(), movimiento.getValor());
            System.out.println(saldoDisponibleActualizar);
            System.out.println(movimiento.getSaldo());
            System.out.println(cuenta.getSaldoInicial());
            movimiento.setSaldo(saldoDisponibleActualizar);
            cuenta.setSaldoInicial(saldoDisponibleActualizar);
            System.out.println(saldoDisponibleActualizar);
            System.out.println(movimiento.getSaldo());
            System.out.println(cuenta.getSaldoInicial());
        } else {
            throw new RuntimeException("Cuenta no encontrada");
        }

    }

    @Override
    public void delete(Long id) {
        try {
            movimientoRepository.deleteById(id);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al eliminar movimiento. %s", e));
            throw new RuntimeException("Error al eliminar movimiento", e);
        }
    }

    @Override
    public List<Movimiento> getAll() {
        try {
            return movimientoRepository.findAll();
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al obtener listado de movimientos. %s", e));
            throw new RuntimeException("Error al obtener listado de movimientos", e);
        }
    }

    @Override
    public Optional<Movimiento> getMovimientoById(Long id) {
        try {
            return movimientoRepository.findById(id);
        } catch (Exception e) {
            LOGGER.severe(String.format("Error al obtener movimiento por id. %s", e));
            throw new RuntimeException("Error al obtener movimiento por id", e);
        }
    }
}
