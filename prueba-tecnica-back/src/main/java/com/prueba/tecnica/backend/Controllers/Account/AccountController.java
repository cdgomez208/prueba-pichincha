package com.prueba.tecnica.backend.Controllers.Account;

import com.prueba.tecnica.backend.dtos.Account.AccountDTO;
import com.prueba.tecnica.backend.dtos.Account.CreateAccountDTO;
import com.prueba.tecnica.backend.dtos.Account.ResponseAccountDTO;
import com.prueba.tecnica.backend.dtos.Account.UpdateAccountDTO;
import com.prueba.tecnica.backend.dtos.ResponseDTO;
import com.prueba.tecnica.backend.servicesImpl.AccountServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("account")
@CrossOrigin(origins = "*")
@RestController
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @ApiOperation(value = "get account by Id", response = ResponseDTO.class)
    @RequestMapping(value = "getAccount/{idAccount}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccount(@PathVariable int idAccount) {
        return ResponseEntity.ok(accountService.getAccountById(idAccount));
    }
    @ApiOperation(value = "delete Account", response = ResponseDTO.class)
    @RequestMapping(value = "delete/{idAccount}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(
            @PathVariable Integer idAccount
    ) {
        return ResponseEntity.ok(accountService.deleteAccountById(idAccount));
    }
    @ApiOperation(value = "getAccount", response = ResponseDTO.class)
    @RequestMapping(value = "getAccount", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccount() {
        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @ApiOperation(value = "create Account", response = ResponseDTO.class)
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountDTO dto) throws Exception {

        ResponseAccountDTO response = accountService.createAccount(dto);
        return ResponseEntity.created(URI.create("/account/v1" ))
                .body(response);
    }
    @ApiOperation(value = "update Account", response = ResponseDTO.class)
    @RequestMapping(value = "update/{idAccount}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@PathVariable int idAccount, @RequestBody UpdateAccountDTO updateAccountDTO)
            throws Exception {
        AccountDTO response = accountService.updateAccount(updateAccountDTO, idAccount);
        return ResponseEntity.ok(response);
    }

}
