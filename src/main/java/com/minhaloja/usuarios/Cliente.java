package com.minhaloja.usuarios;

import com.minhaloja.compra.Compra;

public class Cliente extends UsuarioBase implements Compra {
    public Cliente(String email, String nome) {
        super(email, nome);
    }

    @Override
    public void comprarProduto() {

    }
}
