package com.prueba.tecnica.backend.dtos.Account;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component

public class ResponseAccountDTO {

    private AccountDTO accountDTO;
    private String mensaje;
}
