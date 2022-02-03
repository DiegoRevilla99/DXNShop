/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.producto;

import com.example.DXNShop.catalogo.Catalogo;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author xeng_
 */
@Configuration
public class ProductoConfig {

    @Bean
    CommandLineRunner commandLineRunner3(ProductoRepository repository) {
        return args -> {
         // Producto producto1 = new Producto("Papas","Papas sabritas", 10, "No image","Kilos", 40,20,1);
          //Producto producto2 = new Producto("Pan bimbo","Grande", 5, "No image","Paquete", 70, 50,1);
          //Producto producto3 = new Producto("Jumbo", "No image",19,"Power max","G", 230,150,2);
          //Producto producto2 = new Producto("Acondicionador","Con aceite de almendras", 7, "No image", "Unidad",50, 30,3);
//            repository.saveAll(List.of(producto1, producto2));
        };
    };
}
