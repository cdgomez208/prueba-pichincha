package com.prueba.tecnica.backend.repositories;

import com.prueba.tecnica.backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "select * from clientes " +
            "where idcliente= :idcliente", nativeQuery = true)
    Client userById(
            @Param("idcliente") Integer id

    );

    @Query(value = "delete from clientes " +
            "where idcliente= :idcliente", nativeQuery = true)
    Client deleteUserById(
            @Param("idcliente") Integer id

    );

}
