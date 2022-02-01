/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.tarjeta;

import com.example.DXNShop.usuario.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author aleja
 */
@Configuration
public class TarjetaConfig {
    @Bean
    CommandLineRunner commandLineRunner2(TarjetaRepository repository) {
        return args -> {
            Tarjeta t1 = new Tarjeta("5539273747293737", "BBVA", 342, "03/30", new Usuario("alejandr2o@gmail.com"));
            repository.save(t1);
        };
    };
}
