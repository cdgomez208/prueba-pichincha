package com.prueba.tecnica.backend.mappers;


import com.prueba.tecnica.backend.dtos.Client.ClientDTO;
import com.prueba.tecnica.backend.dtos.Client.CreateClientDTO;
import com.prueba.tecnica.backend.dtos.Client.UpdateClientDTO;
import com.prueba.tecnica.backend.entities.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper( imports = Objects.class )
public interface ClientMapper {
 ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

   ClientDTO map(Client source);
    @InheritInverseConfiguration(name = "map")
    @Mapping(source= "idClient", target= "id")
    @Mapping(source= "password", target= "contrasena")
    @Mapping(source= "estado", target= "estado")
    @Mapping(source= "nombre", target= "nombre")
    @Mapping(source= "genero", target= "genero")
    @Mapping(source= "edad", target= "edad")
    @Mapping(source= "identificacion", target= "identificacion")
    @Mapping(source= "direccion", target= "direccion")
    @Mapping(source= "telefono", target= "telefono")

    Client map(ClientDTO source);



    CreateClientDTO mapCreate(Client source);
    @InheritInverseConfiguration(name = "mapCreate")
   // @Mapping(source= "idClient", target= "id")
    @Mapping(source= "password", target= "contrasena")
    @Mapping(source= "estado", target= "estado")
    @Mapping(source= "nombre", target= "nombre")
    @Mapping(source= "genero", target= "genero")
    @Mapping(source= "edad", target= "edad")
    @Mapping(source= "identificacion", target= "identificacion")
    @Mapping(source= "direccion", target= "direccion")
    @Mapping(source= "telefono", target= "telefono")
    Client mapCreate(CreateClientDTO source);





 ClientDTO mapUpdate(Client source);
    @InheritInverseConfiguration(name = "mapUpdate")
    @Mapping(source= "password", target= "contrasena")
    @Mapping(source= "estado", target= "estado")
    @Mapping(source= "nombre", target= "nombre")
    @Mapping(source= "genero", target= "genero")
    @Mapping(source= "edad", target= "edad")
    @Mapping(source= "identificacion", target= "identificacion")
    @Mapping(source= "direccion", target= "direccion")
    @Mapping(source= "telefono", target= "telefono")
    Client mapUpdate(ClientDTO source);
}
