/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.carrito;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aleja
 */
@RestController
@RequestMapping(path = "carrito")
public class CarritoController {
    private final CarritoService carritoService;

    @Autowired
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public List<Carrito> getCarritos() {
        return carritoService.getClientes();
    }

    @PostMapping
    public void registerNewCarrito(@RequestBody Carrito carrito) {
        carritoService.addNewCarrito(carrito);
    }

    @DeleteMapping(path = "{idc}")
    public void deleteUsuario(@PathVariable("idc") Long idc) {
        carritoService.deleteCarrito(idc);
    }

    @PutMapping(path = "{idc}")
    public void updateCarrito(
            @PathVariable("idc") Long icd,
            @RequestParam(required = false) String usuario_email
    ) {
        carritoService.updateCarrito(icd, usuario_email);
    }
}
