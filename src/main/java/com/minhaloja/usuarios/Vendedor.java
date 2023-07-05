package com.minhaloja.usuarios;

import com.minhaloja.produtos.Produto;
import com.minhaloja.produtos.ProdutoDB;
import com.minhaloja.vende.Vende;

import java.io.*;

public class Vendedor extends UsuarioBase implements Vende {
    private ProdutoDB produtoDB; // cada vendedor tem seu próprio banco

    public Vendedor(String email, String nome) {
        super(email, nome);
        this.produtoDB = new ProdutoDB();
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        produtoDB.addProduto(produto);
    }

}
