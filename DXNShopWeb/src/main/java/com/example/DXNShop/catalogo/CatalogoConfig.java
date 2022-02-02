/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.catalogo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author xeng_
 */
@Configuration
public class CatalogoConfig {
     @Bean
    CommandLineRunner commandLineRunner5(CatalogoRepository repository) {
        return args -> {
            Catalogo categoria1 = new Catalogo("Alimentos y bebidas", "Alimentos y bebidas naturales");
            Catalogo categoria2 = new Catalogo("Suplementos", "Suplementos alimenticios naturales");
            repository.saveAll(List.of(categoria1, categoria2));
        };
    };
    
}
