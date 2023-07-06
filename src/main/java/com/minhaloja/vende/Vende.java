package com.minhaloja.vende;

import com.minhaloja.produtos.Produto;
import com.minhaloja.produtos.ProdutoDB;

import java.io.File;

public interface Vende {
    void cadastrarProduto(Produto produto, ProdutoDB produtoDB);
}
