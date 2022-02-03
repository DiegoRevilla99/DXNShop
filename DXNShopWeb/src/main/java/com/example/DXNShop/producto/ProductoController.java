/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.producto;

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
@RequestMapping(path = "/producto")
public class ProductoController {

    private final ProductoService productoService;
    
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    
    @GetMapping("/informacion_actual")
    public String inicio(){
        return "DXN-Shop-main/administrador/informacion_actual";
    } 
    
    @GetMapping("/mostrar")
    public String getProductos(Model model) {
        model.addAttribute("productoList", productoService.getProductos());
        return "DXN-Shop-main/administrador/lista_productos";
    }
    
    @GetMapping("/agregar-producto")
    public String agregarProducto(Model model){
        model.addAttribute("producto", new Producto());
        return "DXN-Shop-main/administrador/alta_productos";
    }
    
    @PostMapping("/agregar")
    public String registerNewProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttrs) {
        productoService.addNewProducto(producto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/producto/mostrar";
    }
    
    @GetMapping(path = "/editarproducto/{productoFolio}")
    public String editarProducto(@PathVariable ("productoFolio") Long productoFolio, Model model){
        model.addAttribute("producto", productoService.getProducto(productoFolio));
        //System.out.println(productoFolio + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        return "DXN-Shop-main/administrador/actualizar_productos";
    }
    
    @PostMapping(path= "/editarproducto")
    public String updateProducto(@ModelAttribute Producto producto){
        //System.out.println(producto.getFolio() + "  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        //System.out.println(producto.getNombreproducto() + "  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        productoService.updateProducto(producto.getFolio(), producto.getNombreproducto(),producto.getDescripcion(),
                producto.getExistencia(), producto.getImagen(),producto.getUnidad_medida(), producto.getPrecio_venta(), producto.getPrecio_compra(),
                producto.getCatalogo());
        return "redirect:/producto/mostrar";
    }
    
    @GetMapping("/eliminar/{productoFolio}")
    public String deleteProducto(@PathVariable("productoFolio")Long productoFolio){
        productoService.deleteProducto(productoFolio);
        return "redirect:/producto/mostrar";
    }
    
    @PostMapping
    public void registerNewProducto(@RequestBody Producto producto) {
        productoService.addNewProducto(producto);
    }

    /*@DeleteMapping(path = "{productoFolio}")
    public void deleteProducto(@PathVariable("productoFolio") Long productoFolio) {
        productoService.deleteProducto(productoFolio);
    }*/
  
    
    
    
    

}
