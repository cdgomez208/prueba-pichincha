package com.prueba.tecnica.backend.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "\"cuentas\"", schema = "public")
public class Account implements Serializable {
    @Id
    @Column(name = "numerocuenta", nullable = false)
    private int numCuenta;

    @Column(name = "Tipo", nullable = false)
    private String tip;

    @Column(name = "saldo", nullable = false)
    private int saldo;

    @Column(name = "estado", nullable = false)
    private boolean estadoCuenta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "\"cliente\"", nullable = false)
    private Client clienteCuenta;

}