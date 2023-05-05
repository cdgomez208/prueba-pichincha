package com.prueba.tecnica.backend.dtos.Client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class CreateClientDTO  {

    private String password;

    private String estado;

    private String nombre;

    private String genero;

    private int edad ;

    private String identificacion;

    private String direccion;

    private String telefono;

}
