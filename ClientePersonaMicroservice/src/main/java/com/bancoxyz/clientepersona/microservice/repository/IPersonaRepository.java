/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.clientepersona.microservice.repository;

import com.bancoxyz.clientepersona.microservice.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
