package com.minhaloja.produtos;

import com.minhaloja.usuarios.Vendedor;

public class Produto extends ProdutoBase{
    public Produto(Integer id, String nome, double preco, Vendedor vendedor) {
        super(id, nome, preco, vendedor);
    }


}
