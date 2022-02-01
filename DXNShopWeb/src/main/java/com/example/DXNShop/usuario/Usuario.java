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
    @Column(name = "email")
    private String email;

    @Column(name = "pass")
    private String pass;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "rol_id")
    private int rol_id;

    public Usuario() {
    }

    public Usuario(String email, String pass, String nombre, String apellidos, String telefono, int rol_id) {
        this.email = email;
        this.pass = pass;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.rol_id = rol_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String toString() {
        return "Usuario {email=" + email
                + "password=" + pass
                + "nombre=" + nombre
                + "apellidos=" + apellidos
                + "telefono=" + telefono
                + "rol=" + rol_id + "]";
    }
}
