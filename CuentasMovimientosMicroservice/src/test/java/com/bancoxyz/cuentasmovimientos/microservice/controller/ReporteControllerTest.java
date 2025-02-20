/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.cuentasmovimientos.microservice.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.bancoxyz.cuentasmovimientos.microservice.entity.Cuenta;
import com.bancoxyz.cuentasmovimientos.microservice.entity.Movimiento;
import com.bancoxyz.cuentasmovimientos.microservice.entity.enums.TipoCuentaEnum;
import com.bancoxyz.cuentasmovimientos.microservice.entity.enums.TipoMovimientoEnum;
import com.bancoxyz.cuentasmovimientos.microservice.service.ICuentaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ReporteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ICuentaService cuentaService;

    @Test
    void deberiaObtenerReporteCuentas() throws Exception {
        String nombre = "Juan Perez";
        LocalDate inicio = LocalDate.of(2024, 2, 1);
        LocalDate fin = LocalDate.of(2024, 2, 20);
        Cuenta cuentaEsperada = new Cuenta("123", TipoCuentaEnum.AHORRO, 1000.0, true);
        Movimiento movimiento = new Movimiento(1L, LocalDate.of(2024,02,15),
                TipoMovimientoEnum.RETIRO, -100.0, 800.0);
        movimiento.setCuenta(cuentaEsperada);
        List<Cuenta> cuentasEsperadas = Arrays.asList(cuentaEsperada,
                new Cuenta("567", TipoCuentaEnum.CORRIENTE, 10000.0, true)
        );

        when(cuentaService.reporteEstadoCuenta(nombre, inicio, fin))
                .thenReturn(cuentasEsperadas);

        mockMvc.perform(get("/reportes")
                        .param("nombre", nombre)
                        .param("inicio", "2024-02-01")
                        .param("fin", "2024-02-20"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andDo(print());
        cuentaService.reporteEstadoCuenta(nombre, inicio, fin);
        verify(cuentaService).reporteEstadoCuenta(nombre, inicio, fin);
    }
}