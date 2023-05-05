package com.prueba.tecnica.backend.mappers;

import com.prueba.tecnica.backend.dtos.Account.AccountDTO;
import com.prueba.tecnica.backend.dtos.Account.CreateAccountDTO;
import com.prueba.tecnica.backend.dtos.Account.CreateAccountDTO.CreateAccountDTOBuilder;
import com.prueba.tecnica.backend.entities.Account;
import com.prueba.tecnica.backend.entities.Account.AccountBuilder;
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
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO map(Account source) {
        if ( source == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        return accountDTO;
    }

    @Override
    public Account map(AccountDTO source) {
        if ( source == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        account.clienteCuenta( accountDTOToClient( source ) );
        account.tip( source.getTipo() );
        account.saldo( source.getSaldoInicial() );
        account.estadoCuenta( source.isEstado() );

        return account.build();
    }

    @Override
    public CreateAccountDTO mapCreate(Account source) {
        if ( source == null ) {
            return null;
        }

        CreateAccountDTOBuilder createAccountDTO = CreateAccountDTO.builder();

        return createAccountDTO.build();
    }

    @Override
    public Account mapCreate(CreateAccountDTO source) {
        if ( source == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        account.clienteCuenta( createAccountDTOToClient( source ) );
        account.numCuenta( source.getCuenta() );
        account.tip( source.getTipo() );
        account.saldo( source.getSaldoInicial() );
        account.estadoCuenta( source.isEstado() );

        return account.build();
    }

    @Override
    public AccountDTO mapUpdate(Account source) {
        if ( source == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        return accountDTO;
    }

    @Override
    public Account mapUpdate(AccountDTO source) {
        if ( source == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        account.clienteCuenta( accountDTOToClient1( source ) );
        account.tip( source.getTipo() );
        account.saldo( source.getSaldoInicial() );
        account.estadoCuenta( source.isEstado() );

        return account.build();
    }

    protected Client accountDTOToClient(AccountDTO accountDTO) {
        if ( accountDTO == null ) {
            return null;
        }

        Client client = new Client();

        if ( accountDTO.getIdCliente() != null ) {
            client.setId( accountDTO.getIdCliente() );
        }

        return client;
    }

    protected Client createAccountDTOToClient(CreateAccountDTO createAccountDTO) {
        if ( createAccountDTO == null ) {
            return null;
        }

        Client client = new Client();

        if ( createAccountDTO.getIdCliente() != null ) {
            client.setId( createAccountDTO.getIdCliente() );
        }

        return client;
    }

    protected Client accountDTOToClient1(AccountDTO accountDTO) {
        if ( accountDTO == null ) {
            return null;
        }

        Client client = new Client();

        if ( accountDTO.getIdCliente() != null ) {
            client.setId( accountDTO.getIdCliente() );
        }

        return client;
    }
}
