/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DXNShop.tarjeta;

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
public class TarjetaService {
    private final TarjetaRepository tarjetaRepository;

    public TarjetaService(TarjetaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetaRepository.findAll();
    }

    public Tarjeta getTarjeta(String numeroTarjeta) {
        return tarjetaRepository.findByNumero(numeroTarjeta).orElse(null);

    }

    public void addNewTarjeta(Tarjeta tarjeta) {
        Optional<Tarjeta> tarjetaOptional = tarjetaRepository
                .findByNumero(tarjeta.getNumero());
        if (tarjetaOptional.isPresent()) {
            throw new IllegalStateException("No. de tarjeta registrado anteriormente");
        }
        tarjetaRepository.save(tarjeta);
    }

    public void deleteTarjeta(String numero_tarjeta) {
        boolean exist = tarjetaRepository.existsById(numero_tarjeta);
        if (!exist) {
            throw new IllegalStateException(
                    "La tarjeta con el numero: " + numero_tarjeta + " no existe..."
            );
        }
        tarjetaRepository.deleteById(numero_tarjeta);
    }

    @Transactional
    void updateTarjeta(
            String numero,
            String banco,
            int cvv,
            String vencimiento) {
        Tarjeta tarjeta = tarjetaRepository.findByNumero(numero).
                orElseThrow(() -> new IllegalStateException(
                "La tarjeta asociada al número:  " + numero + " no existe..."
        ));
        if (numero != null && numero.length() > 0
                && !Objects.equals(tarjeta.getNumero(), numero)) {
            tarjeta.setNumero(numero);
        }
        if (banco != null && banco.length() > 0
                && !Objects.equals(tarjeta.getBanco(), banco)) {
            tarjeta.setBanco(banco);
        }
        if (cvv > 0
                && !Objects.equals(tarjeta.getCvv(), cvv)) {
            tarjeta.setCvv(cvv);
        }
        if (vencimiento != null && vencimiento.length() > 0
                && !Objects.equals(tarjeta.getVencimiento(), vencimiento)) {
            tarjeta.setVencimiento(vencimiento);
        }
        tarjetaRepository.save(tarjeta);
    }
}
