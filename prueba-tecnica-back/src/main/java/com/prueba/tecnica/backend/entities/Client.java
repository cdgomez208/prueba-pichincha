package com.prueba.tecnica.backend.entities;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "\"clientes\"", schema = "public")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Client extends Person {

    @Id
    @Column(name = "idcliente", nullable = false)
    private int id;


    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "estado", nullable = false)
    private Boolean estado;


}