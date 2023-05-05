package com.prueba.tecnica.backend.mappers;

import com.prueba.tecnica.backend.dtos.Movements.CreateMovementDTO;
import com.prueba.tecnica.backend.dtos.Movements.MovementDTO;
import com.prueba.tecnica.backend.dtos.Movements.UpdateMovementDTO;
import com.prueba.tecnica.backend.entities.Account;
import com.prueba.tecnica.backend.entities.Account.AccountBuilder;
import com.prueba.tecnica.backend.entities.Movement;
import com.prueba.tecnica.backend.entities.Movement.MovementBuilder;
import java.util.Objects;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T16:39:35-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Microsoft)"
)
@Component
public class MovementMapperImpl implements MovementMapper {

    @Override
    public MovementDTO map(Movement source) {
        if ( source == null ) {
            return null;
        }

        MovementDTO movementDTO = new MovementDTO();

        movementDTO.setFecha( source.getFecha() );

        return movementDTO;
    }

    @Override
    public Movement map(MovementDTO source) {
        if ( source == null ) {
            return null;
        }

        MovementBuilder movement = Movement.builder();

        movement.account( movementDTOToAccount( source ) );
        movement.tipo( source.getTipoMovimiento() );
        movement.movimientoCuenta( source.getMovimiento() );
        movement.saldodisponible( source.getSaldoDisponible() );
        movement.fecha( source.getFecha() );

        return movement.build();
    }

    @Override
    public CreateMovementDTO mapCreate(Movement source) {
        if ( source == null ) {
            return null;
        }

        CreateMovementDTO createMovementDTO = new CreateMovementDTO();

        return createMovementDTO;
    }

    @Override
    public Movement mapCreate(CreateMovementDTO source) {
        if ( source == null ) {
            return null;
        }

        MovementBuilder movement = Movement.builder();

        movement.account( createMovementDTOToAccount( source ) );
        movement.tipo( source.getTipoMovimiento() );
        movement.movimientoCuenta( source.getMovimiento() );
        movement.tipoSolicitud( source.getOpcion() );

        return movement.build();
    }

    @Override
    public UpdateMovementDTO mapUpdate(Movement source) {
        if ( source == null ) {
            return null;
        }

        UpdateMovementDTO updateMovementDTO = new UpdateMovementDTO();

        return updateMovementDTO;
    }

    @Override
    public Movement mapUpdate(UpdateMovementDTO source) {
        if ( source == null ) {
            return null;
        }

        MovementBuilder movement = Movement.builder();

        movement.account( updateMovementDTOToAccount( source ) );
        movement.tipo( source.getTipoMovimiento() );
        movement.movimientoCuenta( source.getMovimiento() );
        movement.tipoSolicitud( source.getOpcion() );

        return movement.build();
    }

    protected Account movementDTOToAccount(MovementDTO movementDTO) {
        if ( movementDTO == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        account.numCuenta( movementDTO.getNumeroCuenta() );

        return account.build();
    }

    protected Account createMovementDTOToAccount(CreateMovementDTO createMovementDTO) {
        if ( createMovementDTO == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        account.numCuenta( createMovementDTO.getNumeroCuenta() );

        return account.build();
    }

    protected Account updateMovementDTOToAccount(UpdateMovementDTO updateMovementDTO) {
        if ( updateMovementDTO == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        account.numCuenta( updateMovementDTO.getNumeroCuenta() );

        return account.build();
    }
}
