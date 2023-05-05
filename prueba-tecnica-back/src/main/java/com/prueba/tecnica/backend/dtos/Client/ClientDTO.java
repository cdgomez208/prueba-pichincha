package com.prueba.tecnica.backend.dtos.Client;


import lombok.*;

@Data

public class ClientDTO { // extends PersonDTO {

    private int idClient;


    private String password;


    private Boolean estado;


    //personDTO

    private String nombre;


    private String genero;


    private int edad ;


    private String identificacion;


    private String direccion;


    private String telefono;
}
