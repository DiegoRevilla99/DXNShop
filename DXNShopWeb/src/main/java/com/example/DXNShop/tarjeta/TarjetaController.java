/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.tarjeta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author aleja
 */
@Controller
@RequestMapping(path = "/tarjeta")
public class TarjetaController {
    private final TarjetaService tarjetaService;

    @Autowired
    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @GetMapping(value="/mostrar_tarjetas")
    public String getTarjetas(Model model) {
        model.addAttribute("tarjetasList", tarjetaService.getTarjetas() );
        return "DXN-Shop-main/perfil/tarjeta-list";
    }

    @GetMapping("/agregar-tarjeta")
    public String agregarTarjeta(Model model){
        model.addAttribute("tarjeta", new Tarjeta());
        return "DXN-Shop-main/perfil/alta_tarjeta";
    }
    
    @PostMapping("/agregar")
    public String registerNewTarjeta(@ModelAttribute Tarjeta tarjeta, RedirectAttributes redirectAttrs) {
        tarjetaService.addNewTarjeta(tarjeta);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/tarjeta/mostrar_tarjetas";
    }

    @GetMapping("/eliminar/{numero_tarjeta}")
    public String deleteTarjeta(@PathVariable("numero_tarjeta")String numero_tarjeta){
        tarjetaService.deleteTarjeta(numero_tarjeta);
        return "redirect:/tarjeta/mostrar_tarjetas";
    }
    
    @GetMapping(path = "/editartarjeta/{numero_tarjeta}")
    public String editarTarjeta(@PathVariable ("numero_tarjeta") String numeroTarjeta, Model model){
        model.addAttribute("tarjeta", tarjetaService.getTarjeta(numeroTarjeta));
        System.out.println(numeroTarjeta + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        return "DXN-Shop-main/perfil/editar_tarjeta";
    }
    
    @PostMapping(path= "/editartarjeta")
    public String updateTarjeta(@ModelAttribute Tarjeta tarjeta){
        System.out.println(tarjeta.getNumero()+ "  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(tarjeta.getBanco() + "  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        tarjetaService.updateTarjeta(tarjeta.getNumero(),tarjeta.getBanco(), tarjeta.getCvv(), tarjeta.getVencimiento());
        return "redirect:/tarjeta/mostrar_tarjetas";
    }
}
