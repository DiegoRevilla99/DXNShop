/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.cliente;

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
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public void addNewCliente(Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository
                .findClienteByEmail(cliente.getEmail());
        if (clienteOptional.isPresent()) {
            throw new IllegalStateException("Email registrado anteriormente");
        }
        clienteRepository.save(cliente);
    }

    public void deleteCliente(String email) {
        boolean exist = clienteRepository.existsById(email);
        if (!exist) {
            throw new IllegalStateException(
                    "El cliente con el email: " + email + " no existe"
            );
        }
    }

    @Transactional
    void updateProducto(
            String email,
            String nombre,
            String apellidos,
            String telefono) {
            Cliente cliente = clienteRepository.findById(email).
                orElseThrow(() -> new IllegalStateException(
                "El cliente con el email: " + email + " no existe..."
        ));
        if (nombre != null && nombre.length() > 0
                && !Objects.equals(cliente.getNombre(), nombre)) {
                cliente.setNombre(nombre);
        }
        if (apellidos != null && apellidos.length() > 0
                && !Objects.equals(cliente.getApellidos(), apellidos)) {
                cliente.setApellidos(apellidos);
        }
        if (telefono != null && telefono.length() > 0
                && !Objects.equals(cliente.getTelefono(), telefono)) {
                cliente.setTelefono(telefono);
        }

        clienteRepository.save(cliente);
    }
}
