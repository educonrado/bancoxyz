package com.bancoxyz.cuentasmovimientos.microservice.entity.enums;

public enum TipoCuentaEnum {
    AHORRO("AHO", "Ahorros"),
    CORRIENTE("COR", "Corriente");

    private String codigo;
    private String descripcion;

    TipoCuentaEnum(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
