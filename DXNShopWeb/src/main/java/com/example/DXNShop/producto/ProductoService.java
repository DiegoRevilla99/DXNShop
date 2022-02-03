/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.producto;

import com.example.DXNShop.catalogo.Catalogo;
import static java.lang.System.console;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aleja
 */
@Service
public class ProductoService {
    
    private final ProductoRepository productoRepository;
    
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }
    
    public Producto getProducto(Long folio) {
        return productoRepository.findByFolio(folio).orElse(null);

    }
    
    public void addNewProducto(Producto producto) {
        Optional<Producto> productoOptional = productoRepository
                .findByNombre(producto.getNombreproducto());
        if (productoOptional.isPresent()) {
            throw new IllegalStateException("Producto ya registrado anteriormente");
        }
        productoRepository.save(producto);
    }
    
    public void deleteProducto(Long folio) {
        boolean exist = productoRepository.existsById(folio);
        if (!exist) {
            throw new IllegalStateException(
                    "El producto con el folio: " + folio
                    + " no existe..."
            );
        }
        productoRepository.deleteById(folio);
    }
    
    @Transactional
    void updateProducto(
            Long folio, 
            String nombreproducto,
            String descripcion, 
            int existencia, 
            String imagen,
            String unidad_medida, 
            double precio_venta, 
            double precio_compra,
            Catalogo catalogo) {
        
        //System.out.println(folio + "  ##########################################################################################################");
        Producto producto = productoRepository.findByFolio(folio).
                orElseThrow(() -> new IllegalStateException(
                "El producto con el folio " + folio + " no existe..."
        ));
        
        if (nombreproducto != null && nombreproducto.length() > 0) {
            producto.setNombreproducto(nombreproducto);
        }
        
        if (descripcion != null && descripcion.length() > 0) {
            producto.setDescripcion(descripcion);
        }
        
        if (existencia > 0) {
            producto.setExistencia(existencia);
        }
        
        if (imagen != null && imagen.length() > 0) {
            producto.setImagen(imagen);
        }
        
        if (unidad_medida != null && unidad_medida.length() > 0) {
            producto.setUnidad_medida(unidad_medida);
        }
        
        if (precio_venta > 0) {
            producto.setPrecio_venta(precio_venta);
        }
        
        if (precio_compra > 0) {
            producto.setPrecio_compra(precio_compra);
        }
        
        productoRepository.save(producto);
    }
}
