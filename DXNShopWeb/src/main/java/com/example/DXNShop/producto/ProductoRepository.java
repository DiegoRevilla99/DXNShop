/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.DXNShop.producto;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aleja
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    @Query("Select s from Producto s where s.folio =?1")
    Optional<Producto> findByFolio(Long folio);
    
    @Query("Select s from Producto s where s.nombreproducto =?1")
    Optional<Producto> findByNombre(String nombre);
    
}
