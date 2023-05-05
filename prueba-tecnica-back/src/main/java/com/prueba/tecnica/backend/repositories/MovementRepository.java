package com.prueba.tecnica.backend.repositories;

import com.prueba.tecnica.backend.entities.Account;
import com.prueba.tecnica.backend.entities.Client;
import com.prueba.tecnica.backend.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Integer> {

    @Query(value = "select * from movimientos " +
            "where id= :id", nativeQuery = true)
    Movement movementById(
            @Param("id") Integer id

    );


    @Query(value = "SELECT \n" +
            "            m.id,\n" +
            "            m.fecha,\n" +
            "            m.movimiento, \n" +
            "            m.saldodisponible ,\n" +
            "            m.numerocuenta ,\n" +
            "            m.tipomovimiento,\n" +
            "            m.tiposolicitud,\n" +
            "            c.saldo\n" +
            "            FROM movimientos AS m\n" +
            "                    INNER JOIN cuentas AS c ON m.numerocuenta = c.numerocuenta\n" +
            "                    INNER JOIN clientes AS cl ON c.cliente = cl.idcliente\n" +
            "   WHERE cl.idcliente = :id AND m.fecha >= :fechaInicial AND m.fecha <= :fechaFinal", nativeQuery = true)
    List<Movement> getMovementsByDateAndIdClient(
            @Param("id") Integer id,
            @Param("fechaInicial") LocalDate fechaInicial,
            @Param("fechaFinal") LocalDate fechaFinal
    );





}
