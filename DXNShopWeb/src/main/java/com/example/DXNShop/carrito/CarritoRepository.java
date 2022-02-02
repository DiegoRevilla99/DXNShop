/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.DXNShop.carrito;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aleja
 */
@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long>{
    @Query("Select s from Carrito s where s.usuario_email =?1")
    Optional<Carrito> findCarritoByEmail(String email);
}
