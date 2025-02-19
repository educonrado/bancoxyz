/*
 * Copyright (c) 2025.
 */

package com.bancoxyz.clientepersona.microservice.repository;

import com.bancoxyz.clientepersona.microservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
