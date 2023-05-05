package com.prueba.tecnica.backend.dtos.Movements;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ResponseMovementDTO {
   private MovementDTO movementDTO;
   private String mensaje;

}
