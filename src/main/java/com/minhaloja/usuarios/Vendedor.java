package com.minhaloja.usuarios;

import com.minhaloja.produtos.Produto;
import com.minhaloja.vende.Vende;

import java.io.File;

public class Vendedor extends UsuarioBase implements Vende {
    public Vendedor(String email, String nome) {
        super(email, nome);
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        File file = new File("./produto.txt");
    }

}
