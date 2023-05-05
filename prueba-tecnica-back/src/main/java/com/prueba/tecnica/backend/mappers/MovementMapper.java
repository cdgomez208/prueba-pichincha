package com.prueba.tecnica.backend.mappers;


import com.prueba.tecnica.backend.dtos.Movements.CreateMovementDTO;
import com.prueba.tecnica.backend.dtos.Movements.MovementDTO;
import com.prueba.tecnica.backend.dtos.Movements.RequestGetMovements;
import com.prueba.tecnica.backend.dtos.Movements.UpdateMovementDTO;
import com.prueba.tecnica.backend.entities.Movement;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

@Mapper( imports = Objects.class )
public interface MovementMapper {

    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    MovementDTO map(Movement source);
    @InheritInverseConfiguration(name = "map")
    @Mapping(source= "numeroCuenta", target= "account.numCuenta")
    @Mapping(source= "tipoMovimiento", target= "tipo")
   // @Mapping(source= "fecha", target= "fecha")
    @Mapping(source= "movimiento", target= "movimientoCuenta")
    @Mapping(source= "saldoDisponible", target= "saldodisponible")
    Movement map(MovementDTO source);


    CreateMovementDTO mapCreate(Movement source);
    @InheritInverseConfiguration(name = "mapCreate")
    @Mapping(source= "numeroCuenta", target= "account.numCuenta")
    @Mapping(source= "tipoMovimiento", target= "tipo")
   // @Mapping(source= "fecha", target= "fecha")
    @Mapping(source= "movimiento", target= "movimientoCuenta")
    @Mapping(source= "opcion", target= "tipoSolicitud")
    Movement mapCreate(CreateMovementDTO source);


    UpdateMovementDTO mapUpdate(Movement source);
    @InheritInverseConfiguration(name = "mapUpdate")
    @Mapping(source= "numeroCuenta", target= "account.numCuenta")
    @Mapping(source= "tipoMovimiento", target= "tipo")
    // @Mapping(source= "fecha", target= "fecha")
    @Mapping(source= "movimiento", target= "movimientoCuenta")
    @Mapping(source= "opcion", target= "tipoSolicitud")
    Movement mapUpdate(UpdateMovementDTO source);



}
