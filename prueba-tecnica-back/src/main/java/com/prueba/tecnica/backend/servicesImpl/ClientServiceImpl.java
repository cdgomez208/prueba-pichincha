package com.prueba.tecnica.backend.servicesImpl;



import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import com.prueba.tecnica.backend.dtos.Client.ClientDTO;
import com.prueba.tecnica.backend.dtos.Client.CreateClientDTO;
import com.prueba.tecnica.backend.dtos.Client.ResponseClientDTO;
import com.prueba.tecnica.backend.dtos.Client.UpdateClientDTO;
import com.prueba.tecnica.backend.entities.Client;
import com.prueba.tecnica.backend.mappers.ClientMapper;
import com.prueba.tecnica.backend.mappers.Mapper;
import com.prueba.tecnica.backend.repositories.ClientRepository;
import com.prueba.tecnica.backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    ClientMapper clientMapper;

    Mapper map = new Mapper();

    @Override
    public ResponseClientDTO createClient(CreateClientDTO createClientDTO) throws Exception {
        Random random = new Random();

        int randomInt = random.nextInt(Integer.MAX_VALUE);

        Client client = clientMapper.mapCreate(createClientDTO);
        client.setId(randomInt);
        ResponseClientDTO responseClientDTO = new ResponseClientDTO();
        client = clientRepository.save(client);

        ClientDTO clientDTO =map.mapClient(client);
        responseClientDTO.setClientDTO(clientDTO);
        responseClientDTO.setMensaje("se ha creado el cliente "+clientDTO.getIdClient());
        return responseClientDTO;
    }

    @Override
    public ClientDTO updateClient(UpdateClientDTO updateClientDTO, int idClient) throws Exception {

        ResponseClientDTO responseClientDTO= new ResponseClientDTO();
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new ResourceNotFoundException("usuario no se encuentra " + idClient));

        client.setId(client.getId());
        client.setContrasena(updateClientDTO.getPassword());
        client.setDireccion(updateClientDTO.getDireccion());
        client.setEdad(updateClientDTO.getEdad());
        client.setEstado(updateClientDTO.getEstado());
        client.setNombre(updateClientDTO.getNombre());
        client.setGenero(updateClientDTO.getGenero());
        client.setEdad(updateClientDTO.getEdad());
        client.setIdentificacion(updateClientDTO.getIdentificacion());
        client.setDireccion(updateClientDTO.getDireccion());
        client.setTelefono(updateClientDTO.getTelefono());

        Client savedClient = clientRepository.save(client);
         return  map.mapClient(savedClient);

    }

    @Override
    public String  deleteClientById(int idClient) {
        Client validate= getClientById(idClient);
        if(validate!=null) {
            clientRepository.deleteById(idClient);

            return "se ha eliminado el cliente";
        }else
           return  "no existe el cliente";
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map((client) -> mapToDto(client)
        ).collect(Collectors.toList());
    }

    @Override
    public Client getClientById(int idClient) {
        return clientRepository.userById(idClient);

    }

    private ClientDTO mapToDto(Client client) {
        ClientDTO dto = clientMapper.map(client);
        return dto;

    }
}
