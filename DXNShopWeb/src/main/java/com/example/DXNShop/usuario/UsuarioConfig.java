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
            Usuario usuario1 = new Usuario("alejandro@gmail.com", "Alejandro",1);
            Usuario usuario2 = new Usuario("antonio@gmail.com", "Antonio", 1);
            repository.save(usuario1);
        };
    };
}
