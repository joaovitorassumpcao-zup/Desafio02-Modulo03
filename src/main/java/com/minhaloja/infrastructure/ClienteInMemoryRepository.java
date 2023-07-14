package com.minhaloja.infrastructure;

import com.minhaloja.domain.models.UserCliente;
import com.minhaloja.domain.repositories.ClienteRepository;

import java.util.*;

public class ClienteInMemoryRepository implements ClienteRepository {

    private List<UserCliente> dataBase;

    public ClienteInMemoryRepository() {
        this.dataBase = new ArrayList<>();
    }

    @Override
    public UserCliente update(UserCliente cliente) {
        if (dataBase.contains(cliente)) {
            dataBase.set(dataBase.indexOf(cliente), cliente);
        } else {
            dataBase.add(cliente);
        }
        return cliente;
    }

    @Override
    public List<UserCliente> getAll() {
        return Collections.unmodifiableList(dataBase);
    }

    @Override
    public Optional<UserCliente> getByEmail(String email) {
        return dataBase.stream().filter(
                v -> v.getEmail().equalsIgnoreCase(email)
        ).findFirst();
    }
}
