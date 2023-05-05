package com.prueba.tecnica.backend.dtos.Account;

import lombok.Data;


@Data

public class AccountDTO {


    private int cuenta;


    private String tipo;


    private int saldoInicial;


    private boolean estado;

    private Integer idCliente;


}
