package com.minhaloja.produtos;

import java.util.ArrayList;

public class ProdutoDB { // SIMULA UM BANCO DE DADOS
    private ArrayList<Produto> produtoDB;

    public ArrayList<Produto> getProdutos() {
        return produtoDB;
    }

    public void addProduto(Produto produto) {
        produtoDB.add(produto);
    }

    public void setProduto(int pos, Produto produto) {
        this.produtoDB.set(pos, produto);
    }

    public Produto getProduto(int pos) {
        return produtoDB.get(pos);
    }

    public void remProduto(int pos) {
        produtoDB.remove(pos);
    }
}
