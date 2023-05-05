package com.prueba.tecnica.backend.services;

import com.prueba.tecnica.backend.dtos.Account.AccountDTO;
import com.prueba.tecnica.backend.dtos.Account.CreateAccountDTO;

import com.prueba.tecnica.backend.dtos.Account.ResponseAccountDTO;
import com.prueba.tecnica.backend.dtos.Account.UpdateAccountDTO;



import com.prueba.tecnica.backend.entities.Account;


import java.util.List;

public interface AccountService {

    ResponseAccountDTO createAccount(CreateAccountDTO createAccountDTO) throws Exception;

    AccountDTO updateAccount(UpdateAccountDTO updateAccountDTO, int idAccount) throws Exception;

    String deleteAccountById(int idAccount);
    List<AccountDTO> getAllAccount();
    Account getAccountById(int idAccount);





}
