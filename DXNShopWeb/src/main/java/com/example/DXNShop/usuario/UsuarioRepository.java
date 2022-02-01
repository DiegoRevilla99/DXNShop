/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.DXNShop.usuario;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author aleja
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("Select s from Usuario s where s.email =?1")
    Optional<Usuario> findUsuarioByEmail(String email);
}
