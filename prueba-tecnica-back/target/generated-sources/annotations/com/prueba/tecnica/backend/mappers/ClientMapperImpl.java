package com.prueba.tecnica.backend.mappers;

import com.prueba.tecnica.backend.dtos.Client.ClientDTO;
import com.prueba.tecnica.backend.dtos.Client.CreateClientDTO;
import com.prueba.tecnica.backend.dtos.Client.CreateClientDTO.CreateClientDTOBuilder;
import com.prueba.tecnica.backend.entities.Client;
import java.util.Objects;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T16:39:35-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Microsoft)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO map(Client source) {
        if ( source == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setEstado( source.getEstado() );
        clientDTO.setNombre( source.getNombre() );
        clientDTO.setGenero( source.getGenero() );
        clientDTO.setEdad( source.getEdad() );
        clientDTO.setIdentificacion( source.getIdentificacion() );
        clientDTO.setDireccion( source.getDireccion() );
        clientDTO.setTelefono( source.getTelefono() );

        return clientDTO;
    }

    @Override
    public Client map(ClientDTO source) {
        if ( source == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( source.getIdClient() );
        client.setContrasena( source.getPassword() );
        client.setEstado( source.getEstado() );
        client.setNombre( source.getNombre() );
        client.setGenero( source.getGenero() );
        client.setEdad( source.getEdad() );
        client.setIdentificacion( source.getIdentificacion() );
        client.setDireccion( source.getDireccion() );
        client.setTelefono( source.getTelefono() );

        return client;
    }

    @Override
    public CreateClientDTO mapCreate(Client source) {
        if ( source == null ) {
            return null;
        }

        CreateClientDTOBuilder createClientDTO = CreateClientDTO.builder();

        if ( source.getEstado() != null ) {
            createClientDTO.estado( String.valueOf( source.getEstado() ) );
        }
        createClientDTO.nombre( source.getNombre() );
        createClientDTO.genero( source.getGenero() );
        createClientDTO.edad( source.getEdad() );
        createClientDTO.identificacion( source.getIdentificacion() );
        createClientDTO.direccion( source.getDireccion() );
        createClientDTO.telefono( source.getTelefono() );

        return createClientDTO.build();
    }

    @Override
    public Client mapCreate(CreateClientDTO source) {
        if ( source == null ) {
            return null;
        }

        Client client = new Client();

        client.setContrasena( source.getPassword() );
        if ( source.getEstado() != null ) {
            client.setEstado( Boolean.parseBoolean( source.getEstado() ) );
        }
        client.setNombre( source.getNombre() );
        client.setGenero( source.getGenero() );
        client.setEdad( source.getEdad() );
        client.setIdentificacion( source.getIdentificacion() );
        client.setDireccion( source.getDireccion() );
        client.setTelefono( source.getTelefono() );

        return client;
    }

    @Override
    public ClientDTO mapUpdate(Client source) {
        if ( source == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setEstado( source.getEstado() );
        clientDTO.setNombre( source.getNombre() );
        clientDTO.setGenero( source.getGenero() );
        clientDTO.setEdad( source.getEdad() );
        clientDTO.setIdentificacion( source.getIdentificacion() );
        clientDTO.setDireccion( source.getDireccion() );
        clientDTO.setTelefono( source.getTelefono() );

        return clientDTO;
    }

    @Override
    public Client mapUpdate(ClientDTO source) {
        if ( source == null ) {
            return null;
        }

        Client client = new Client();

        client.setContrasena( source.getPassword() );
        client.setEstado( source.getEstado() );
        client.setNombre( source.getNombre() );
        client.setGenero( source.getGenero() );
        client.setEdad( source.getEdad() );
        client.setIdentificacion( source.getIdentificacion() );
        client.setDireccion( source.getDireccion() );
        client.setTelefono( source.getTelefono() );

        return client;
    }
}
