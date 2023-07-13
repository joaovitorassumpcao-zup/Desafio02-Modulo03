package com.minhaloja.domain.services;

import com.minhaloja.domain.models.UserVendedor;
import com.minhaloja.domain.repositories.VendedorRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class VendedorService {
    private VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public UserVendedor update(UserVendedor vendedor) {
        return this.vendedorRepository.update(vendedor);
    }

    public List<UserVendedor> getAll() {
        return vendedorRepository.getAll();
    }

    public UserVendedor getByEmail(String email) {
        return vendedorRepository.getByEmail(email).orElseThrow(
                () -> new NoSuchElementException("Vendedor de email " + email + " não encontrado")
        );
    }
}
