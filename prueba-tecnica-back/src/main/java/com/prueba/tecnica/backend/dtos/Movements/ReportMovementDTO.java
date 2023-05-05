package com.prueba.tecnica.backend.dtos.Movements;

import lombok.Data;

import java.util.Date;

@Data
public class ReportMovementDTO {

    private Date Fecha;

    private String nombreCliente;

    private int numeroCuenta;

    private String tipoMovimiento;

    private int saldoInicial;

    private Boolean estado;

    private int movimiento;

    private int saldoDisponible;
}
