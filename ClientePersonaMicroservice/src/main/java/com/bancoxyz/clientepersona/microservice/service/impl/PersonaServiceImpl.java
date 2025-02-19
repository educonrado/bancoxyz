/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.clientepersona.microservice.service.impl;

import com.bancoxyz.clientepersona.microservice.entity.Persona;
import com.bancoxyz.clientepersona.microservice.repository.IPersonaRepository;
import com.bancoxyz.clientepersona.microservice.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }
}
