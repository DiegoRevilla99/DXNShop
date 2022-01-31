/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.cliente;

import java.util.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author aleja
 */
@Configuration
public class ClienteConfig {
    @Bean
    CommandLineRunner commandLineRunner2(ClienteRepository repository) {
        return args -> {
            Cliente cliente1 = new Cliente("alejandro@gmail.com", "Alejandro", "Diaz", "9511789781");
            Cliente cliente2 = new Cliente("antonio@gmail.com", "Antonio", "Diaz", "9513476700");
            repository.save(cliente1);
        };
    };
}
