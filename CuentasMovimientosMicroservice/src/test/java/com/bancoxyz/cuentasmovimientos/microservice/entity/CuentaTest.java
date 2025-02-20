/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.entity;

import com.bancoxyz.cuentasmovimientos.microservice.entity.enums.TipoCuentaEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {

    @Test
    public void deberiaModificarDireccion() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123456");
        assertEquals("123456", cuenta.getNumeroCuenta());
    }

    @Test
    public void deberiaCrearCuenta() {
        Cuenta cuenta = new Cuenta("123", TipoCuentaEnum.AHORRO, 100.0, true);

        assertNotNull(cuenta);

        assertEquals("123", cuenta.getNumeroCuenta());
        assertEquals(TipoCuentaEnum.AHORRO, cuenta.getTipoCuenta());
        assertEquals(100.0, cuenta.getSaldoInicial());
        assertTrue(cuenta.isEstado());

        assertNotNull(cuenta.toString());

        assertTrue(cuenta.toString().contains("123"));
        assertTrue(cuenta.toString().contains("AHORRO"));
        assertTrue(cuenta.toString().contains("100.0"));
        assertTrue(cuenta.toString().contains("true"));
    }
}