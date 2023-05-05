package com.prueba.tecnica.backend.servicesImpl;

import com.prueba.tecnica.backend.dtos.Account.AccountDTO;
import com.prueba.tecnica.backend.dtos.Account.CreateAccountDTO;
import com.prueba.tecnica.backend.dtos.Account.ResponseAccountDTO;
import com.prueba.tecnica.backend.dtos.Account.UpdateAccountDTO;
import com.prueba.tecnica.backend.entities.Account;
import com.prueba.tecnica.backend.mappers.AccountMapper;
import com.prueba.tecnica.backend.mappers.Mapper;
import com.prueba.tecnica.backend.repositories.AccountRepository;
import com.prueba.tecnica.backend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    Mapper map = new Mapper();

    @Override
    public ResponseAccountDTO createAccount(CreateAccountDTO createAccountDTO) throws Exception {
        Random random = new Random();
        int randomInt = random.nextInt(Integer.MAX_VALUE);
        ResponseAccountDTO accountResponse = new ResponseAccountDTO();
        Account validateAccount = getAccountById(createAccountDTO.getCuenta());
        if (validateAccount == null) {
            Account account = accountMapper.mapCreate(createAccountDTO);
            account.setNumCuenta(randomInt);
            account = accountRepository.save(account);
            AccountDTO accountC = map.mapAccount(account);
            accountResponse.setMensaje("se ha creado la cuenta " + accountC.getCuenta());
            accountResponse.setAccountDTO(accountC);
            return accountResponse;
        } else
            accountResponse.setMensaje("ya existe la cuenta");
        accountResponse.setAccountDTO(null);
        return accountResponse;
    }

    @Override
    public AccountDTO updateAccount(UpdateAccountDTO updateAccountDTO, int idAccount) throws Exception {

        Account account = accountRepository.findById(idAccount).orElseThrow(() -> new NotFoundException("la cuenta " + idAccount + "no existe"));
        account.setNumCuenta(account.getNumCuenta());
        account.setEstadoCuenta(updateAccountDTO.getEstado());
        account.setTip(updateAccountDTO.getTipo());
        account.setSaldo(updateAccountDTO.getSaldoInicial());
        account.getClienteCuenta().setId(updateAccountDTO.getIdCliente());

        Account accountSaved = accountRepository.save(account);
        AccountDTO accountConvert = map.mapAccount(accountSaved);
        return accountConvert;

    }

    @Override
    public String deleteAccountById(int idAccount) {

        Account validateAccount = getAccountById(idAccount);
        if (validateAccount != null) {
            accountRepository.deleteById(idAccount);
            return "se ha eliminado la cuenta ";
        } else
            return "no existe la cuenta";
    }

    @Override
    public List<AccountDTO> getAllAccount() {
        return accountRepository.findAll().stream().map((account) -> mapToDto(account)
        ).collect(Collectors.toList());
    }

    @Override
    public Account getAccountById(int idAccount) {
        return accountRepository.accountById(idAccount);
    }

    private AccountDTO mapToDto(Account account) {
        AccountDTO dto = accountMapper.map(account);
        return dto;

    }
}
