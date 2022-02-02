/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.carrito;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aleja
 */
@Service
public class CarritoService {
    private final CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public List<Carrito> getClientes() {
        return carritoRepository.findAll();
    }

    public Carrito getCarrito(Long idc){
        return carritoRepository
                .findById(idc)
                .orElse(null);
    }

    void addNewCarrito(Carrito carrito) {
        Optional<Carrito> carritoOptional = carritoRepository
                .findCarritoByEmail(carrito.getUsuario_email());
        if (carritoOptional.isPresent()) {
            throw new IllegalStateException("Email registrado");
        }
        carritoRepository.save(carrito);
    }

    public void deleteCarrito(Long idc) {
        boolean exist = carritoRepository.existsById(idc);
        if (!exist) {
            throw new IllegalStateException(
                    "El carrito con el ID " + idc + " no existe..."
            );
        }
        carritoRepository.deleteById(idc);
    }

    @Transactional
    void updateCarrito(
            Long idc,
            String usuario_email) {
        Carrito carrito = carritoRepository.findById(idc).
                orElseThrow(() -> new IllegalStateException(
                "El carrito con el ID " + idc + " no existe"
        ));
        if (usuario_email != null && usuario_email.length() > 0 && 
            !Objects.equals(carrito.getUsuario_email(), usuario_email)) {
            carrito.setUsuario_email(usuario_email);
        }
        carritoRepository.save(carrito);
    }
}
