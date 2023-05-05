package com.prueba.tecnica.backend.servicesImpl;


import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import com.prueba.tecnica.backend.dtos.Account.AccountDTO;
import com.prueba.tecnica.backend.dtos.Movements.*;
import com.prueba.tecnica.backend.entities.Account;
import com.prueba.tecnica.backend.entities.Movement;
import com.prueba.tecnica.backend.mappers.Mapper;
import com.prueba.tecnica.backend.mappers.MovementMapper;
import com.prueba.tecnica.backend.repositories.MovementRepository;
import com.prueba.tecnica.backend.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    MovementMapper movementMapper;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    Mapper map = new Mapper();

    @Override
    public ResponseMovementDTO createMovement(CreateMovementDTO createMovementDTO) throws Exception {
        Random random = new Random();

        Date fechaActual = new Date();
        ResponseMovementDTO responseMovementDTO = new ResponseMovementDTO();
        //find to account exists
        Account validateAccount = accountServiceImpl.getAccountById(createMovementDTO.getNumeroCuenta());
        if (validateAccount != null) {

            int randomInt = random.nextInt(Integer.MAX_VALUE);
            //transform entity to dto
            AccountDTO account = map.mapAccount(validateAccount);
            System.out.print("Conversion" + account);
            if (account.getSaldoInicial() != 0) {
                Movement movement = movementMapper.mapCreate(createMovementDTO);
                movement.setId(randomInt);
                movement.setFecha(fechaActual);
                if (createMovementDTO.getOpcion().equals("retiro")) {
                    movement.setSaldodisponible(account.getSaldoInicial() - createMovementDTO.getMovimiento());
                    ResponseMovementDTO response = mapAndSaveMovement(movement);
                    return response;
                }
                if (createMovementDTO.getOpcion().equals("deposito")) {
                    movement.setSaldodisponible(account.getSaldoInicial() + createMovementDTO.getMovimiento());
                    ResponseMovementDTO response = mapAndSaveMovement(movement);
                    return response;
                } else {
                    responseMovementDTO.setMensaje("opcion invalida");
                }
            } else {
                responseMovementDTO.setMensaje("saldo no disponible");
            }
        } else responseMovementDTO.setMensaje("no existe ninguna cuenta asociada");


        return responseMovementDTO;
    }

    @Override
    public ResponseMovementDTO updateMovement(UpdateMovementDTO updateMovementDTO, int idMovement) throws Exception {

        Date fechaActual = new Date();
        Movement movement = movementRepository.findById(idMovement)
                .orElseThrow(() -> new ResourceNotFoundException("movimiento no se encuentra " + idMovement));


        //get Account
        Account validateAccount = accountServiceImpl.getAccountById(updateMovementDTO.getNumeroCuenta());

        AccountDTO account = map.mapAccount(validateAccount);
        movement.setId(idMovement);
        movement.setFecha(fechaActual);
        movement.getAccount().setNumCuenta(updateMovementDTO.getNumeroCuenta());
        movement.getAccount().setSaldo(account.getSaldoInicial());
        movement.setMovimientoCuenta(updateMovementDTO.getMovimiento());
        movement.setTipo(updateMovementDTO.getTipoMovimiento());

        movement.setMovimientoCuenta(updateMovementDTO.getMovimiento());
        movement.getAccount().setEstadoCuenta(account.isEstado());


        if (updateMovementDTO.getOpcion().equals("retiro")) {
            movement.setSaldodisponible(account.getSaldoInicial() - updateMovementDTO.getMovimiento());
            ResponseMovementDTO response = mapAndUpdateMovement(movement);
            return response;
        }
        if (updateMovementDTO.getOpcion().equals("deposito")) {
            movement.setSaldodisponible(account.getSaldoInicial() + updateMovementDTO.getMovimiento());

            ResponseMovementDTO response = mapAndUpdateMovement(movement);
            return response;
        }
        return null;
    }

    @Override
    public String deleteMovementById(int idMovement) {
        Movement movement = getMovementById(idMovement);
        if (movement != null) {
            movementRepository.deleteById(idMovement);
            return "Movimiento eliminado";
        } else {
            return "no existe el movimiento";
        }
    }

    @Override
    public List<MovementDTO> getAllMovements() {
        return null;
    }

    @Override
    public Movement getMovementById(int idMovement) {
        return movementRepository.movementById(idMovement);
    }

    @Override
    public List<ReportMovementDTO> getAllMovementsByClient(RequestGetMovements requestGetMovements) {
        List<ReportMovementDTO> report = new ArrayList<>();
        Mapper mapper = new Mapper();

        List<Movement> movements = movementRepository.getMovementsByDateAndIdClient(requestGetMovements.getId(), requestGetMovements.getFechaInicio(), requestGetMovements.getFechaFin());

        for (Movement movement : movements) {
            ReportMovementDTO convertReport = mapper.mapReport(movement);
            report.add(convertReport);
        }
        return report;
    }


    public ResponseMovementDTO mapAndSaveMovement(Movement movement) {
        Mapper mapper = new Mapper();

        ResponseMovementDTO movementResponse = new ResponseMovementDTO();
        movement = movementRepository.save(movement);
        MovementDTO movementConver = mapper.mapMovement(movement);
        movementResponse.setMovementDTO(movementConver);
        movementResponse.setMensaje("se ha creado el movimiento " + movementConver.getIdMovement());
        return movementResponse;
    }

    public ResponseMovementDTO mapAndUpdateMovement(Movement movement) {
        Mapper mapper = new Mapper();
        Movement savedMovement = movementRepository.save(movement);
        ResponseMovementDTO movementC = mapper.mapUpdateMovement(savedMovement);
        movementC.setMensaje("se actualizo el movimiento " + movementC.getMovementDTO().getIdMovement());
        return movementC;
    }


}
