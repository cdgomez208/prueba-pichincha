package com.prueba.tecnica.backend.mappers;

import com.prueba.tecnica.backend.dtos.Account.AccountDTO;
import com.prueba.tecnica.backend.dtos.Account.CreateAccountDTO;
import com.prueba.tecnica.backend.entities.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper( imports = Objects.class )
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDTO map(Account source);
    @InheritInverseConfiguration(name = "map")
  //  @Mapping(source= "cuenta", target= "numCuenta")
    @Mapping(source= "tipo", target= "tip")
    @Mapping(source= "saldoInicial", target= "saldo")
    @Mapping(source= "estado", target= "estadoCuenta")
    @Mapping(source= "idCliente", target= "clienteCuenta.id")
    Account map(AccountDTO source);



    CreateAccountDTO mapCreate(Account source);
    @InheritInverseConfiguration(name = "mapCreate")
    @Mapping(source= "cuenta", target= "numCuenta")
    @Mapping(source= "tipo", target= "tip")
    @Mapping(source= "saldoInicial", target= "saldo")
    @Mapping(source= "estado", target= "estadoCuenta")
    @Mapping(source= "idCliente", target= "clienteCuenta.id")
    Account mapCreate(CreateAccountDTO source);


   AccountDTO mapUpdate(Account source);
    @InheritInverseConfiguration(name = "mapUpdate")
    //@Mapping(source= "cuenta", target= "numCuenta")
    @Mapping(source= "tipo", target= "tip")
    @Mapping(source= "saldoInicial", target= "saldo")
    @Mapping(source= "estado", target= "estadoCuenta")
    @Mapping(source= "idCliente", target= "clienteCuenta.id")
    Account mapUpdate(AccountDTO source);




}
