package com.prueba.tecnica.backend.repositories;

import com.prueba.tecnica.backend.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "select * from cuentas " +
            "where numerocuenta= :numerocuenta", nativeQuery = true)
    Account accountById(
            @Param("numerocuenta") Integer numeroCuenta

    );


    @Query(value = "select * from cuentas " +
            "where cliente= :clienteCuenta", nativeQuery = true)
    List<Account> accountByClient(
            @Param("clienteCuenta") Integer clienteCuenta

    );



}
