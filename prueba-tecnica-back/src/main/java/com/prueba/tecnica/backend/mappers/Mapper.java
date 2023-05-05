package com.prueba.tecnica.backend.mappers;

import com.prueba.tecnica.backend.dtos.Account.AccountDTO;
import com.prueba.tecnica.backend.dtos.Client.ClientDTO;
import com.prueba.tecnica.backend.dtos.Movements.MovementDTO;
import com.prueba.tecnica.backend.dtos.Movements.ReportMovementDTO;
import com.prueba.tecnica.backend.dtos.Movements.ResponseMovementDTO;
import com.prueba.tecnica.backend.entities.Account;
import com.prueba.tecnica.backend.entities.Client;
import com.prueba.tecnica.backend.entities.Movement;

public class Mapper {

    public AccountDTO mapAccount(Account account){
        AccountDTO accountDTO= new AccountDTO();
        accountDTO.setCuenta(account.getNumCuenta());
        accountDTO.setIdCliente(account.getClienteCuenta().getId());
        accountDTO.setEstado(account.getClienteCuenta().getEstado());
        accountDTO.setSaldoInicial(account.getSaldo());
        accountDTO.setTipo(account.getTip());
        return accountDTO;
    }

    public MovementDTO mapMovement(Movement movement){
        MovementDTO movementDTO= new MovementDTO();
        movementDTO.setIdMovement(movement.getId());
        movementDTO.setFecha(movement.getFecha());
        movementDTO.setEstado(movement.getAccount().isEstadoCuenta());
        movementDTO.setSaldoInicial(movement.getAccount().getSaldo());
        movementDTO.setNumeroCuenta(movement.getAccount().getNumCuenta());
        movementDTO.setSaldoDisponible(movement.getSaldodisponible());
        movementDTO.setMovimiento(movement.getMovimientoCuenta());
        movementDTO.setTipoMovimiento(movement.getTipo());
        return movementDTO;
    }

    public ResponseMovementDTO mapUpdateMovement(Movement movement){
        ResponseMovementDTO updateMovementDTO= new ResponseMovementDTO();
        MovementDTO update = new MovementDTO();
        update.setIdMovement(movement.getId());
        update.setFecha(movement.getFecha());
        update.setEstado(movement.getAccount().isEstadoCuenta());
        update.setSaldoInicial(movement.getAccount().getSaldo());
        update.setNumeroCuenta(movement.getAccount().getNumCuenta());
        update.setSaldoDisponible(movement.getSaldodisponible());
        update.setMovimiento(movement.getMovimientoCuenta());
        update.setTipoMovimiento(movement.getTipo());
        updateMovementDTO.setMovementDTO(update);
        return updateMovementDTO;
    }


    public ReportMovementDTO mapReport(Movement movement){
        ReportMovementDTO report= new ReportMovementDTO();


        report.setFecha(movement.getFecha());
        report.setEstado(movement.getAccount().isEstadoCuenta());
        report.setSaldoInicial(movement.getAccount().getSaldo());
        report.setNumeroCuenta(movement.getAccount().getNumCuenta());
        report.setSaldoDisponible(movement.getSaldodisponible());
        report.setMovimiento(movement.getMovimientoCuenta());
        report.setTipoMovimiento(movement.getTipo());
        report.setNombreCliente(movement.getAccount().getClienteCuenta().getNombre());

        return report;
    }



    public ClientDTO mapClient(Client client){
        ClientDTO clientDTO= new ClientDTO();
        clientDTO.setIdClient(client.getId());
        clientDTO.setDireccion(client.getDireccion());
        clientDTO.setPassword(client.getContrasena());
        clientDTO.setGenero(client.getGenero());
        clientDTO.setTelefono(client.getTelefono());
        clientDTO.setNombre(client.getNombre());
        clientDTO.setIdentificacion(client.getIdentificacion());
        clientDTO.setEdad(client.getEdad());
        clientDTO.setEstado(client.getEstado());

        return clientDTO;
    }

}
