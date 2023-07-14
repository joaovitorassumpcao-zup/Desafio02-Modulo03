package com.minhaloja.domain.repositories;

import com.minhaloja.domain.models.UserCliente;

import java.util.List;
import java.util.Optional;


public interface ClienteRepository {
    UserCliente update(UserCliente cliente);
    List<UserCliente> getAll();
    Optional<UserCliente> getByEmail(String email);
}
