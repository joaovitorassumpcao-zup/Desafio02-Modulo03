package com.minhaloja.infrastructure;

import com.minhaloja.domain.models.UserVendedor;
import com.minhaloja.domain.repositories.VendedorRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VendedorInMemoryRepository implements VendedorRepository {
    private List<UserVendedor> dataBase;

    public VendedorInMemoryRepository() {
        this.dataBase = new ArrayList<>();
    }

    @Override
    public UserVendedor update(UserVendedor vendedor) {
        if (dataBase.contains(vendedor)) {
            dataBase.set(dataBase.indexOf(vendedor), vendedor);
        } else {
            dataBase.add(vendedor);
        }
        return vendedor;
    }

    @Override
    public List<UserVendedor> getAll() {
        return Collections.unmodifiableList(dataBase);
    }

    @Override
    public Optional<UserVendedor> getByEmail(String email) {
        return dataBase.stream().filter(
                v -> v.getEmail().equalsIgnoreCase(email)
        ).findFirst();
    }
}
