/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.tarjeta;

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
@RequestMapping(path = "tarjeta")
public class TarjetaController {
    private final TarjetaService tarjetaService;

    @Autowired
    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @GetMapping
    public List<Tarjeta> getTarjetas() {
        return tarjetaService.getTarjetas();
    }

    @PostMapping
    public void registerNewTarjeta(@RequestBody Tarjeta tarjeta) {
        tarjetaService.addNewTarjeta(tarjeta);
    }

    @DeleteMapping(path = "{numero}")
    public void deleteTarjeta(@PathVariable("numero") String numero) {
        tarjetaService.deleteTarjeta(numero);
    }

    @PutMapping(path = "{numero}")
    public void updateUsuario(
            @PathVariable("numero") String numero,
            @RequestParam(required = false) String banco,
            @RequestParam(required = false) int cvv,
            @RequestParam(required = false) String vencimiento
    ) {
        tarjetaService.updateTarjeta(numero, banco, cvv, vencimiento);
    }
}
