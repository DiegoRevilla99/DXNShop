/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.catalogo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author xeng_
 */
@Service
public class CatalogoService {
    
    private final CatalogoRepository catalogoRepository;
    
    public CatalogoService(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }
    
    public List<Catalogo> getCatalogos() {
        return catalogoRepository.findAll();
    }
    
    public Catalogo getCatalogo(Long id) {
        return catalogoRepository.findById(id).orElse(null);

    }
    
    public Catalogo getCatalogoProductos(Long id) {
        return catalogoRepository.findById(id).orElse(null);

    }
    
    public void addNewCatalogo(Catalogo catalogo) {
        Optional<Catalogo> catalogoOptional = catalogoRepository
                .findByNombre(catalogo.getNombre());
        if (catalogoOptional.isPresent()) {
            throw new IllegalStateException("Catalogo ya registrado anteriormente");
        }
        catalogoRepository.save(catalogo);
    }
    
    public void deleteCatalogo(Long id) {
        boolean exist = catalogoRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException(
                    "El catálogo con el id: " + id
                    + " no existe..."
            );
        }
        catalogoRepository.deleteById(id);
    }
    
    @Transactional
    void updateCatalogo(
            Long id, 
            String nombre,
            String descripcion) {
        
        Catalogo catalogo = catalogoRepository.findById(id).
                orElseThrow(() -> new IllegalStateException(
                "El catálogo con el id " + id + " no existe..."
        ));
        
        if (nombre != null && nombre.length() > 0) {
            catalogo.setNombre(nombre);
        }
        
        if (descripcion != null && descripcion.length() > 0) {
            catalogo.setDescripcion(descripcion);
        }       
        catalogoRepository.save(catalogo);
    }
    
    
}
