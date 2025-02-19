/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.clientepersona.microservice.entity;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Persona {

    private String clientId;
    private String contrasenia;
    private boolean estado;

    public Cliente(String clientId, String contrasenia, boolean estado) {
        this.clientId = clientId;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public Cliente(String nombre, String genero, Integer edad, String identificacion, String direccion, String telefono, String clientId, String contrasenia, boolean estado) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.clientId = clientId;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public Cliente() {

    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clientId='" + clientId + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", estado=" + estado +
                '}';
    }
}
