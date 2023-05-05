package com.prueba.tecnica.backend.dtos.Movements;


import lombok.Data;


@Data
public class CreateMovementDTO {

    private int numeroCuenta;

    private String tipoMovimiento;

    private int movimiento;

    private String opcion;


}
