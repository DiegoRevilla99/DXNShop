/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aleja
 */
@Entity 
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "cliente_email")
    private String cliente_email;

    @Column(name = "pass")
    private String pass;

    @Column(name = "rol_id")
    private int rol_id;

    public Usuario() {
    }

    public Usuario(String cliente_email, String pass, int rol_id) {
        this.cliente_email = cliente_email;
        this.pass = pass;
        this.rol_id = rol_id;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public String getPass() {
        return pass;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String toString() {
        return "Usuario {email=}" + cliente_email
                + "password=" + pass
                + "rol=" + rol_id + "]";
    }
}
