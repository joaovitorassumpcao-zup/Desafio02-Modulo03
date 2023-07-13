package com.minhaloja.domain.repositories;

import com.minhaloja.domain.models.UserVendedor;

import java.util.List;
import java.util.Optional;

public interface VendedorRepository {
    UserVendedor update(UserVendedor vendedor);
    List<UserVendedor> getAll();
    Optional<UserVendedor> getByEmail(String email);
}
