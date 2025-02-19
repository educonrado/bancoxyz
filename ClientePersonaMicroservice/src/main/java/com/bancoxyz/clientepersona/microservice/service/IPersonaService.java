/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.clientepersona.microservice.service;

import com.bancoxyz.clientepersona.microservice.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    public Persona save(Persona persona);
    public void delete(Long id);
    public List<Persona> getAll();
    public Optional<Persona> getPersonaById(Long id);
}
