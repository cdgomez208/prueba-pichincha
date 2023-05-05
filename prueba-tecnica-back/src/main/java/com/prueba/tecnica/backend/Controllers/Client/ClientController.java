package com.prueba.tecnica.backend.Controllers.Client;

import com.prueba.tecnica.backend.dtos.Client.ClientDTO;
import com.prueba.tecnica.backend.dtos.Client.CreateClientDTO;
import com.prueba.tecnica.backend.dtos.Client.ResponseClientDTO;
import com.prueba.tecnica.backend.dtos.Client.UpdateClientDTO;
import com.prueba.tecnica.backend.dtos.ResponseDTO;
import com.prueba.tecnica.backend.repositories.ClientRepository;
import com.prueba.tecnica.backend.servicesImpl.ClientServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;


@RequestMapping("client")
@CrossOrigin(origins = "*")
@RestController
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private ClientRepository clientRepository;


    @ApiOperation(value = "get client by Id", response = ResponseDTO.class)
    @RequestMapping(value = "getClient/{idClient}", method = RequestMethod.GET)
    public ResponseEntity<?> getClient(@PathVariable int idClient) {
        return ResponseEntity.ok(clientService.getClientById(idClient));
    }
    @ApiOperation(value = "delete Client", response = ResponseDTO.class)
    @RequestMapping(value = "delete/{idClient}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(
            @PathVariable Integer idClient
    ) {
        return ResponseEntity.ok(clientService.deleteClientById(idClient));
    }
    @ApiOperation(value = "getClient", response = ResponseDTO.class)
    @RequestMapping(value = "getClient", method = RequestMethod.GET)
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @ApiOperation(value = "create Client", response = ResponseDTO.class)
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createClient(@RequestBody CreateClientDTO dto) throws Exception {

        ResponseClientDTO response = clientService.createClient(dto);
        return ResponseEntity.created(URI.create("/client/v1" ))
                .body(response);
    }
    @ApiOperation(value = "update Client", response = ResponseDTO.class)
    @RequestMapping(value = "update/{idClient}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClient(@PathVariable int idClient, @RequestBody UpdateClientDTO updateClientDTO) throws Exception {
        ClientDTO response = clientService.updateClient(updateClientDTO, idClient);
        return ResponseEntity.ok(response);
    }

}
