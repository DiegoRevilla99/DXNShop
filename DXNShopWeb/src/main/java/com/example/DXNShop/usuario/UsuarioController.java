/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aleja
 */
@RestController
@RequestMapping(path = "usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public void registerNewUsuario(@RequestBody Usuario usuario) {
        usuarioService.addNewUsuario(usuario);
    }

    @DeleteMapping(path = "{email}")
    public void deleteUsuario(@PathVariable("email") String email) {
        usuarioService.deleteUsuario(email);
    }

    @PutMapping(path = "{email}")
    public void updateUsuario(
            @PathVariable("email") String email,
            @RequestParam(required = false) String pass,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String telefono,
            @RequestParam(required = false) int rol_id
    ) {
        usuarioService.updateUsuario(email, pass, nombre, apellidos, telefono, rol_id);
    }
}
