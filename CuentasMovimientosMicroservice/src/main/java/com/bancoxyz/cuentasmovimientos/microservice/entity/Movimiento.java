package com.bancoxyz.cuentasmovimientos.microservice.entity;

import com.bancoxyz.cuentasmovimientos.microservice.entity.enums.TipoMovimientoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Movimiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private TipoMovimientoEnum tipoMovimiento;
    private Double valor;
    @JsonIgnore
    private Double saldo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id")
    @JsonBackReference
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(Long id, LocalDate fecha, TipoMovimientoEnum tipoMovimiento, Double valor, Double saldo) {
        this.id = id;
        this.fecha = Objects.isNull(fecha) ? LocalDate.now(): fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        //.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoMovimientoEnum getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimientoEnum tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tipoMovimiento=" + tipoMovimiento +
                ", valor=" + valor +
                ", saldo=" + saldo +
                ", cuenta=" + cuenta +
                '}';
    }
}
