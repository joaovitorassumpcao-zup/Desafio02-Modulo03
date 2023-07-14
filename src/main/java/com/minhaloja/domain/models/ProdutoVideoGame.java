package com.minhaloja.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoVideoGame implements Produto{
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private LocalDateTime dataCompra;

    public ProdutoVideoGame(Integer id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataCompra = LocalDateTime.now();
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public BigDecimal getPreco() {
        return this.preco;
    }

    @Override
    public Venda vender(UserCliente cliente, UserVendedor vendedor, BigDecimal valor) {
        return new Venda(cliente, vendedor, this, valor);
    }
}
