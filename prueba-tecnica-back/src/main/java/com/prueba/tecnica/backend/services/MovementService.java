package com.prueba.tecnica.backend.services;

import com.prueba.tecnica.backend.dtos.Movements.*;
import com.prueba.tecnica.backend.entities.Movement;

import java.util.List;

public interface MovementService {

    ResponseMovementDTO createMovement(CreateMovementDTO createMovementDTO) throws Exception;

    ResponseMovementDTO updateMovement(UpdateMovementDTO updateMovementDTO, int idMovement) throws Exception;

    String deleteMovementById(int idMovement);
    List<MovementDTO> getAllMovements();
    Movement getMovementById(int idMovement);

    List<ReportMovementDTO> getAllMovementsByClient(RequestGetMovements requestGetMovements );

}
