/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.usuario;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author aleja
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public void addNewUsuario(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository
                .findUsuarioByEmail(usuario.getEmail());
        if (usuarioOptional.isPresent()) {
            throw new IllegalStateException("Email registrado anteriormente");
        }
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String email) {
        boolean exist = usuarioRepository.existsById(email);
        if (!exist) {
            throw new IllegalStateException(
                    "El cliente con el email: " + email + " no existe"
            );
        }
    }

    @Transactional
    void updateUsuario(
            String email,
            String pass,
            String nombre,
            String apellidos,
            String telefono,
            int rol_id) {
        Usuario usuario = usuarioRepository.findById(email).
                orElseThrow(() -> new IllegalStateException(
                "El cliente con el email: " + email + " no existe..."
        ));
        if (email != null && email.length() > 0
                && !Objects.equals(usuario.getEmail(), email)) {
            usuario.setEmail(email);
        }
        if (pass != null && pass.length() > 0
                && !Objects.equals(usuario.getPass(), pass)) {
            usuario.setPass(pass);
        }
        if (nombre != null && nombre.length() > 0
                && !Objects.equals(usuario.getNombre(), nombre)) {
            usuario.setNombre(nombre);
        }
        if (apellidos != null && apellidos.length() > 0
                && !Objects.equals(usuario.getApellidos(), apellidos)) {
            usuario.setApellidos(apellidos);
        }
        if (telefono != null && telefono.length() > 0
                && !Objects.equals(usuario.getTelefono(), telefono)) {
            usuario.setTelefono(telefono);
        }
        if (rol_id != 0
                && !Objects.equals(usuario.getRol_id(), rol_id)) {
            usuario.setRol_id(rol_id);
        }
        usuarioRepository.save(usuario);
    }
}
