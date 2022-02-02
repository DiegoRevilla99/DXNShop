/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.carrito;

import com.example.DXNShop.producto.Producto;
import com.example.DXNShop.usuario.Usuario;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author aleja
 */

@Entity
@Table (name = "carrito")
public class Carrito {
    @Id
    @SequenceGenerator(
            name = "carrito_sequence",
            sequenceName = "carrito_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "carrito_sequence"
    )
    @Column(name = "idc")
    private Long idc;

    @Column(name = "usuario_email")
    private String usuario_email;

    @ManyToOne
    @JoinColumn(name = "email")
    private Usuario usuario;

    public Carrito() {
    }

    public Carrito(Long idc, String usuario_email) {
        this.idc = idc;
        this.usuario_email = usuario_email;
    }

    public Carrito(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIdc(Long idc) {
        this.idc = idc;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdc() {
        return idc;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String toString(){
        return "Carrito {idc=" + idc
                + " usuario_email=" + usuario_email + "}";
    }
}
