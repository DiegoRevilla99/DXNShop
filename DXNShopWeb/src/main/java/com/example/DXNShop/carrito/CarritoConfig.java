/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.carrito;

import com.example.DXNShop.usuario.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author aleja
 */
@Configuration
public class CarritoConfig {
     @Bean
    CommandLineRunner commandLineRunnerCarrito(CarritoRepository repository) {
        return args -> {
            //Carrito carrito = new Carrito(new Usuario("alejandro@gmail.com"));
            //repository.save(carrito);
        };
    };
}
