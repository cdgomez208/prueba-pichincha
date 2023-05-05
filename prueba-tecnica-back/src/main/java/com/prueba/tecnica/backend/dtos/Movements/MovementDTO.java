package com.prueba.tecnica.backend.dtos.Movements;


import lombok.Data;

import java.util.Date;

@Data

public class MovementDTO  {

    private int idMovement;


    private int numeroCuenta;


    private String tipoMovimiento;



    private int saldoInicial;


    private Boolean estado;

    private Date Fecha;


    private int movimiento;


    private int saldoDisponible;

}
