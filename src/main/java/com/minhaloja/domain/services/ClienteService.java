package com.minhaloja.domain.services;

import com.minhaloja.domain.models.UserCliente;
import com.minhaloja.domain.repositories.ClienteRepository;

import java.util.NoSuchElementException;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public UserCliente getByEmail(String email) {
        return clienteRepository.getByEmail(email).orElseThrow(
                () -> new NoSuchElementException("Cliente de email " + email + " não encontrado"));
    }
}
