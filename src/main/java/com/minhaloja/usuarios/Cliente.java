package com.minhaloja.usuarios;

import com.minhaloja.compra.Compra;
import com.minhaloja.produtos.ProdutoDB;

public class Cliente extends UsuarioBase implements Compra {
    public Cliente(String email, String nome) {
        super(email, nome);
    }

    @Override
    public void comprarProduto(ProdutoDB produtoDB) {

    }
}
