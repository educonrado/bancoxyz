/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.service.impl;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;
import com.bancoxyz.cuentasmovimientos.microservice.entity.Movimiento;
import com.bancoxyz.cuentasmovimientos.microservice.entity.enums.TipoCuentaEnum;
import com.bancoxyz.cuentasmovimientos.microservice.entity.enums.TipoMovimientoEnum;
import com.bancoxyz.cuentasmovimientos.microservice.exception.SaldoException;
import com.bancoxyz.cuentasmovimientos.microservice.repository.ICuentaRepository;
import com.bancoxyz.cuentasmovimientos.microservice.repository.IMovimientoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class MovimientoServiceImplTest {

    @InjectMocks
    private MovimientoServiceImpl movimientoServiceImpl;
    @Mock
    private CuentaServiceImpl cuentaServiceImpl;
    @Mock
    private IMovimientoRepository movimientoRepository;

    @Test
    public void deberiaGuardarMovimiento() throws SaldoException {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123");
        cuenta.setTipoCuenta(TipoCuentaEnum.AHORRO);
        cuenta.setSaldoInicial(1000.0);
        cuenta.setEstado(true);

        Movimiento movimiento = new Movimiento();
        movimiento.setValor(-100.0);
        movimiento.setTipoMovimiento(TipoMovimientoEnum.RETIRO);
        movimiento.setCuenta(cuenta);
        when(cuentaServiceImpl.getCuentaById(any())).thenReturn(Optional.of(cuenta));
        when(movimientoRepository.save(any())).thenReturn(movimiento);
        Movimiento movimientoCambiado = movimientoServiceImpl.save(movimiento);
        assertEquals(900.0, movimientoCambiado.getSaldo());
    }

    @Test
    public void deberiaGuardarMovimientoSinSaldo() throws SaldoException {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123");
        cuenta.setTipoCuenta(TipoCuentaEnum.AHORRO);
        cuenta.setSaldoInicial(1000.0);
        cuenta.setEstado(true);

        Movimiento movimiento = new Movimiento();
        movimiento.setValor(-1100.0);
        movimiento.setTipoMovimiento(TipoMovimientoEnum.RETIRO);
        movimiento.setCuenta(cuenta);
        when(cuentaServiceImpl.getCuentaById(any())).thenReturn(Optional.of(cuenta));
        when(movimientoRepository.save(any())).thenReturn(movimiento);
        SaldoException exception = assertThrows(SaldoException.class, () -> movimientoServiceImpl.save(movimiento));
        assertEquals("Saldo no disponible", exception.getMessage());
    }
}