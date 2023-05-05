package com.prueba.tecnica.backend.services;

import com.prueba.tecnica.backend.dtos.Client.ClientDTO;
import com.prueba.tecnica.backend.dtos.Client.CreateClientDTO;
import com.prueba.tecnica.backend.dtos.Client.ResponseClientDTO;
import com.prueba.tecnica.backend.dtos.Client.UpdateClientDTO;
import com.prueba.tecnica.backend.entities.Client;

import java.util.List;

public interface ClientService {

    ResponseClientDTO createClient(CreateClientDTO createClientDTO) throws Exception;

    ClientDTO updateClient(UpdateClientDTO updateClientDTO, int idClient) throws Exception;

    String deleteClientById(int idClient);
    List<ClientDTO> getAllClients();
    Client getClientById(int idClient);
}
