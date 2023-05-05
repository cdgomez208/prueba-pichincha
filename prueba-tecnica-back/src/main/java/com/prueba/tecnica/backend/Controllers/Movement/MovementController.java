package com.prueba.tecnica.backend.Controllers.Movement;


import com.prueba.tecnica.backend.dtos.Movements.CreateMovementDTO;
import com.prueba.tecnica.backend.dtos.Movements.RequestGetMovements;
import com.prueba.tecnica.backend.dtos.Movements.ResponseMovementDTO;
import com.prueba.tecnica.backend.dtos.Movements.UpdateMovementDTO;
import com.prueba.tecnica.backend.dtos.ResponseDTO;
import com.prueba.tecnica.backend.servicesImpl.MovementServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("movement")
@CrossOrigin(origins = "*")
@RestController
public class MovementController {

    @Autowired
    private MovementServiceImpl movementService;

    @ApiOperation(value = "get movement by Id", response = ResponseDTO.class)
    @RequestMapping(value = "getMovement/{idMovement}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovement(@PathVariable int idMovement) {
        return ResponseEntity.ok(movementService.getMovementById(idMovement));
    }
    @ApiOperation(value = "delete Movement", response = ResponseDTO.class)
    @RequestMapping(value = "delete/{idMovement}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMovement(
            @PathVariable Integer idMovement
    ) {
        return ResponseEntity.ok(movementService.deleteMovementById(idMovement));
    }
    @ApiOperation(value = "getMovement", response = ResponseDTO.class)
    @RequestMapping(value = "getMovement", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMovements() {
        return ResponseEntity.ok(movementService.getAllMovements());
    }

    @ApiOperation(value = "create Movement", response = ResponseDTO.class)
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createMovement(@RequestBody CreateMovementDTO dto) throws Exception {

        ResponseMovementDTO response = movementService.createMovement(dto);
        return ResponseEntity.created(URI.create("/Movement/v1" ))
                .body(response);
    }
    @ApiOperation(value = "update Movement", response = ResponseDTO.class)
    @RequestMapping(value = "update/{idMovement}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMovement(@PathVariable int idMovement, @RequestBody UpdateMovementDTO updateMovementDTO)
            throws Exception {
        ResponseMovementDTO response = movementService.updateMovement(updateMovementDTO, idMovement);
        return ResponseEntity.ok(response);
    }


    @ApiOperation(value = "getMovementByParams", response = ResponseDTO.class)
    @RequestMapping(value = "getMovementByParams", method = RequestMethod.GET)
    public ResponseEntity<?> getMovementsByClient(@RequestBody RequestGetMovements requestGetMovements ) {
        return ResponseEntity.ok(movementService.getAllMovementsByClient(  requestGetMovements));
    }



}
