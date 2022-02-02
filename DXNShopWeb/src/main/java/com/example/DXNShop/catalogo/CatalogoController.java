/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.catalogo;
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
 * @author xeng_
 */
@Controller
@RequestMapping(path = "/catalogo")
public class CatalogoController {
    
    private final CatalogoService catalogoService;
    
    @Autowired
    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }
    
    @GetMapping(value="/mostrar")
    public String getCatalogo(Model model) {
        model.addAttribute("catalogoList", catalogoService.getCatalogos());
        return "DXN-Shop-main/administrador/lista_productos";
    }
    
    @GetMapping(value="/mostrarProductos/{catalogoId}")
    public String getCatalogoProductos(@PathVariable ("catalogoId") Long catalogoId, Model model) {
        //model.addAttribute("catalogoProductosList", catalogoService.getCatalogoProductos());
        Catalogo cat = catalogoService.getCatalogo(catalogoId);
        System.out.println(cat.getNombre() + " - " + cat.getProductoList() + "        %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        model.addAttribute("productosCatalogo", cat.getProductoList());
        return "DXN-Shop-main/catalogo/alimentos_bebidas";
    }
    
    @GetMapping("/agregar-catalogo")
    public String agregarCatalogo(Model model){
        model.addAttribute("producto", new Catalogo());
        return "DXN-Shop-main/administrador/alta_productos";
    }
    
    @PostMapping("/agregar")
    public String registerNewCatalogo(@ModelAttribute Catalogo catalogo, RedirectAttributes redirectAttrs) {
        catalogoService.addNewCatalogo(catalogo);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/producto/mostrar";
    }
    
    @GetMapping("/eliminar/{productoFolio}")
    public String deleteCatalogo(@PathVariable("catalogoId")Long catalogoId){
        catalogoService.deleteCatalogo(catalogoId);
        return "redirect:/producto/mostrar";
    }
    
    @GetMapping(path = "/editarproducto/{productoFolio}")
    public String editarCatalogo(@PathVariable ("catalogoId") Long catalogoId, Model model){
        model.addAttribute("producto", catalogoService.getCatalogo(catalogoId));
        
        return "DXN-Shop-main/administrador/actualizar_productos";
    }
    
    @PostMapping(path= "/editarproducto")
    public String updateCatalogo(@ModelAttribute Catalogo catalogo){
        catalogoService.updateCatalogo(catalogo.getId(), catalogo.getNombre(),catalogo.getDescripcion());
        return "redirect:/producto/mostrar";
    }
}
