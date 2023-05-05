package com.prueba.tecnica.backend.dtos.Movements;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class RequestGetMovements {

    private int id;

    private LocalDate fechaInicio;
    private LocalDate FechaFin;

}
