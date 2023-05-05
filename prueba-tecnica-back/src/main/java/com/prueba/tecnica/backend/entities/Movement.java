package com.prueba.tecnica.backend.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "\"movimientos\"", schema = "public")

public class Movement implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "\"numerocuenta\"", nullable = false)
    private Account account;

    @Column(name = "tipomovimiento", nullable = false)
    private String tipo;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "movimiento", nullable = false)
    private int movimientoCuenta;

    @Column(name = "saldodisponible", nullable = false)
    private int saldodisponible;

    @Column(name = "tiposolicitud", nullable = false)
    private String tipoSolicitud;
}
