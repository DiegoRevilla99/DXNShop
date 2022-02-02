/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.catalogo;

/**
 *
 * @author xeng_
 */

import com.example.DXNShop.producto.Producto;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author aleja
 */
@Entity 
@Table
public class Catalogo {
    @Id
    @SequenceGenerator(
            name = "catalogo_sequence",
            sequenceName = "catalogo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "catalogo_sequence"
    )
    
    private Long id;
    private String nombre;
    private String descripcion;
    
    @OneToMany(mappedBy = "catalogo")
    private List<Producto> productoList;
    
    

    public Catalogo() {
    }

    public Catalogo(Long id, String nombre,String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Catalogo(String nombre,String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Catalogo{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
    
    

 
}

