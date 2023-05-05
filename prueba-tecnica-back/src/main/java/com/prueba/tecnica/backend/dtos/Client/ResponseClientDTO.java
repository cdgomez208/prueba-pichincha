package com.prueba.tecnica.backend.dtos.Client;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ResponseClientDTO {

    private ClientDTO clientDTO;
    private String mensaje;
}
