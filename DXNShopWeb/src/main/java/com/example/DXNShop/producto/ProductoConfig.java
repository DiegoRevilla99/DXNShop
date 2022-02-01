/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.producto;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author aleja
 */
@Configuration
public class ProductoConfig {

    @Bean
    CommandLineRunner commandLineRunner3(ProductoRepository repository) {
        return args -> {
            Producto producto1 = new Producto("PAPAS", "Papas sabritas", 10, "No image", "Kilos", 100, 50);
            Producto producto2 = new Producto("REFRESCO", "Refresco", 10, "No image", "Kilos", 100, 50);
            repository.saveAll(List.of(producto1, producto2));
        };
    };
}
