/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.catalogo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author xeng_
 */

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Long>{
    @Query("Select s from Catalogo s where s.nombre =?1")
    Optional<Catalogo> findByNombre(String nombre);
    
    
}
