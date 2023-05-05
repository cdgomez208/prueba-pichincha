import com.prueba.tecnica.backend.Application;
import com.prueba.tecnica.backend.dtos.Account.AccountDTO;
import com.prueba.tecnica.backend.dtos.Account.CreateAccountDTO;
import com.prueba.tecnica.backend.dtos.Account.ResponseAccountDTO;
import com.prueba.tecnica.backend.dtos.Client.ClientDTO;
import com.prueba.tecnica.backend.entities.Account;
import com.prueba.tecnica.backend.entities.Movement;
import com.prueba.tecnica.backend.mappers.AccountMapper;
import com.prueba.tecnica.backend.mappers.Mapper;
import com.prueba.tecnica.backend.mappers.MovementMapper;

import com.prueba.tecnica.backend.repositories.AccountRepository;
import com.prueba.tecnica.backend.servicesImpl.AccountServiceImpl;
import com.prueba.tecnica.backend.servicesImpl.ClientServiceImpl;
import com.prueba.tecnica.backend.servicesImpl.MovementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class testAccount {

    @Mock
    private AccountRepository accountRepository;

    @Spy
    AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    @InjectMocks
    private AccountServiceImpl accountServiceImpl;


    @BeforeEach
    public void setUp() {
        when(accountRepository.findAll()).thenReturn(Stream.of(accountOk()).collect(Collectors.toList()));
        when(accountRepository.getById(Mockito.any())).thenReturn(accountOk());

    }
    @Test
    public void getAllAccount() throws Exception {
        List<AccountDTO> accounts = accountServiceImpl.getAllAccount();
        assertNotNull(accounts);
    }


    private Account accountOk() {
        Account account = Account.builder()
                .numCuenta(1231)
                .build();
        return account;
    }



}
