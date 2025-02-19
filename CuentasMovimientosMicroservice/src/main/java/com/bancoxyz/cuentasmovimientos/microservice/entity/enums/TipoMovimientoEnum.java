package com.bancoxyz.cuentasmovimientos.microservice.entity.enums;

public enum TipoMovimientoEnum {

    RETIRO("RET", "Retiro"),
    DEPOSITO("DEP", "Depósito");

    private String codigo;
    private String descripcion;

    TipoMovimientoEnum(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
