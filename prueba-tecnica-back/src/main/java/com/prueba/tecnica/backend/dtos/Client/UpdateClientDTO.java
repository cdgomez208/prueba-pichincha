package com.prueba.tecnica.backend.dtos.Client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class UpdateClientDTO {

    private String password;

    private Boolean estado;

    private String nombre;

    private String genero;

    private int edad ;

    private String identificacion;

    private String direccion;

    private String telefono;

}
