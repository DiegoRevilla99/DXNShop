/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.usuario;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author aleja
 */
@Configuration
public class UsuarioConfig {

    @Bean
    CommandLineRunner commandLineRunner1(UsuarioRepository repository) {
        return args -> {
            Usuario usuario1 = new Usuario("alejandro@gmail.com", "password", "Alejandro", "Diaz", "9511789781", 1);
            Usuario usuario2 = new Usuario("yeny@gmail.com", "password", "Alejandro", "Diaz", "9511789781", 1);

           // repository.saveAll(List.of(usuario1, usuario2));
          
        };
    }
;
}
