package com.minhaloja.infrastructure;

import com.minhaloja.domain.models.Produto;
import com.minhaloja.domain.repositories.ProdutoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProdutoInMemoryRepository implements ProdutoRepository {
    private List<Produto> dataBase;

    public ProdutoInMemoryRepository() {
        this.dataBase = new ArrayList<>();
    }

    @Override
    public Produto update(Produto produto) {
        if (dataBase.contains(produto)) {
            dataBase.set(dataBase.indexOf(produto), produto);
        } else {
            dataBase.add(produto);
        }
        return produto;
    }

    @Override
    public List<Produto> getAll() {
        return Collections.unmodifiableList(dataBase);
    }

    @Override
    public Optional<Produto> getByID(Integer id) {
        return dataBase.stream().filter(
                v -> v.getID().equals(id)
        ).findFirst();
    }
}
