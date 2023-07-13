package com.minhaloja.domain.repositories;

import com.minhaloja.domain.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Produto update(Produto produto);
    List<Produto> getAll();
    Optional<Produto> getByID(Integer id);
}
