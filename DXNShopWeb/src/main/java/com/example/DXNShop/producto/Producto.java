/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.producto;

import com.example.DXNShop.catalogo.Catalogo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author aleja
 */
@Entity 
@Table
public class Producto {
    @Id
    @SequenceGenerator(
            name = "producto_sequence",
            sequenceName = "producto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "producto_sequence"
    )
    
    private Long folio;
    private String nombreproducto;
    private String descripcion;
    private int existencia;
    private String imagen;
    private String unidad_medida;
    private double precio_venta;
    private double precio_compra;
    
    @ManyToOne
    @JoinColumn(name = "idCatalogo")
    private Catalogo catalogo;
    

    public Producto() {
    }

    public Producto(Long folio, String nombreproducto,String descripcion, int existencia, String imagen,
                    String unidad_medida, double precio_venta, double precio_compra, Catalogo catalogo) {
        this.folio = folio;
        this.nombreproducto = nombreproducto;
        this.descripcion = descripcion;
        this.existencia = existencia;
        this.imagen = imagen;
        this.unidad_medida = unidad_medida;
        this.precio_venta = precio_venta;
        this.precio_compra = precio_compra;
        this.catalogo = catalogo;
    }
    
    public Producto( String nombreproducto,String descripcion, int existencia, String imagen,
                    String unidad_medida, double precio_venta, double precio_compra, Catalogo catalogo) {
        this.nombreproducto = nombreproducto;
        this.descripcion = descripcion;
        this.existencia = existencia;
        this.imagen = imagen;
        this.unidad_medida = unidad_medida;
        this.precio_venta = precio_venta;
        this.precio_compra = precio_compra;
        this.catalogo = catalogo;
    }

    public Long getFolio() {
        return folio;
    }

    public void setFolio(Long folio) {
        this.folio = folio;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
    
    @Override
    public String toString() {
        return "Producto{" + "folio=" + folio + ", nombreproducto=" + nombreproducto + ", descripcion=" + descripcion + ", existencia=" + existencia + ", imagen=" + imagen + ", unidad_medida=" + unidad_medida + ", precio_venta=" + precio_venta + ", precio_compra=" + precio_compra + '}';
    }
    
    
    
    

 
}
