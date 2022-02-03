/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.DXNShop.tarjeta;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aleja
 */
@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, String>{
    @Query("Select s from Tarjeta s where s.numero =?1")
    Optional<Tarjeta> findByNumero(String tarjeta);
}
