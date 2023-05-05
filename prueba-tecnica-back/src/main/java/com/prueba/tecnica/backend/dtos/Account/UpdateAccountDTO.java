package com.prueba.tecnica.backend.dtos.Account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class UpdateAccountDTO  {

    @JsonProperty("cuenta")
    private int cuenta;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("saldoInicial")
    private int saldoInicial;

    @JsonProperty("estado")
    private Boolean estado;

    @JsonProperty("idCliente")
    private Integer idCliente;
}
