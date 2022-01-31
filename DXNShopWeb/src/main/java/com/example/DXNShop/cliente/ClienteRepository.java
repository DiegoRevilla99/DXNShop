/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.DXNShop.cliente;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aleja
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
        @Query("Select s from Cliente s where s.email =?1")
    Optional<Cliente> findClienteByEmail(String email);
}
