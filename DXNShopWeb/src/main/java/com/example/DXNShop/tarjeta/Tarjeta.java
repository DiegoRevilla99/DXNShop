/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.tarjeta;

import com.example.DXNShop.usuario.Usuario;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Diaz Ruiz Alejandro
 */

@Entity 
@Table(name = "tarjeta")
public class Tarjeta {
    @Id
    @Column(name = "numero")
    private String numero;

    @Column(name = "banco")
    private String banco;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "vencimiento")
    @DateTimeFormat (pattern = "MM/yy")
    private String vencimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_email")
    private Usuario usuario;

    public Tarjeta() {
    }

    public Tarjeta(String numero, String banco, int cvv, String vencimiento, Usuario usuario) {
        this.numero = numero;
        this.banco = banco;
        this.cvv = cvv;
        this.vencimiento = vencimiento;
        this.usuario = usuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String toString() {
        return "Tarjeta {numero=" + numero
                + "banco=" + banco
                + "cvv=" + cvv
                + "vencimiento=" + vencimiento + "}";
    }


}