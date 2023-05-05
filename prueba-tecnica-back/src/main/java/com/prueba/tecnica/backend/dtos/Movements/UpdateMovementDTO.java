package com.prueba.tecnica.backend.dtos.Movements;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data

public class UpdateMovementDTO {

    //private int idMovement;


    private int numeroCuenta;


    private String tipoMovimiento;



    //private int saldoInicial;


    //private Boolean estado;

   // private Date Fecha;


    private int movimiento;


   // private int saldoDisponible;

    private String opcion;

}
