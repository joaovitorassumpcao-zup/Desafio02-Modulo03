package com.minhaloja.domain.services;

import com.minhaloja.domain.models.Produto;
import com.minhaloja.domain.repositories.ProdutoRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto update(Produto produto) {
        return this.produtoRepository.update(produto);
    }

    public Produto getById(Integer id) {
        return produtoRepository.getByID(id).orElseThrow(
                () -> new NoSuchElementException("Produto de ID " + id + " não encontrado")
        );
    }

    public List<Produto> getAll(){
        return produtoRepository.getAll();
    }
}
