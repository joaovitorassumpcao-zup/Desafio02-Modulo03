package com.minhaloja.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Venda {
    private Integer Id;
    private UserCliente cliente;
    private UserVendedor vendedor;
    private Produto produto;
    private LocalDateTime data;
    private BigDecimal valor;

    public Venda(Integer ID, Venda venda) {
        this.Id = ID;
        this.cliente = venda.cliente;
        this.vendedor = venda.vendedor;
        this.produto = venda.produto;
        this.valor = venda.valor;
        this.data = venda.data;
    }

    public Venda(Integer ID, UserCliente cliente, UserVendedor vendedor, Produto produto, BigDecimal valor) {
        this.Id = ID;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produto = produto;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    // GETTERS

    public Integer getId() {
        return Id;
    }

    public UserCliente getCliente() {
        return cliente;
    }

    public UserVendedor getVendedor() {
        return vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
