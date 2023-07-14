package com.minhaloja.domain.services;

import com.minhaloja.domain.models.UserCliente;
import com.minhaloja.domain.repositories.ClienteRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public UserCliente update(UserCliente cliente) {
        return this.clienteRepository.update(cliente);
    }

    public List<UserCliente> getAll() {
        return this.clienteRepository.getAll();
    }

    public UserCliente getByEmail(String email) {
        return clienteRepository.getByEmail(email).orElseThrow(
                () -> new NoSuchElementException("Cliente de email " + email + " não encontrado"));
    }
}
