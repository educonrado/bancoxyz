package com.bancoxyz.cuentasmovimientos.microservice.repository;

import com.bancoxyz.cuentasmovimientos.microservice.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Long> {
}
