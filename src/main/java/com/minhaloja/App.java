package com.minhaloja;

import com.minhaloja.produtos.ProdutoDB;
import com.minhaloja.usuarios.UsuarioDB;
import com.minhaloja.vendas.Vendas;

import java.io.*;

public class App {
    public static void main(String[] args) {
        UsuarioDB usuarioDB = new UsuarioDB();
        ProdutoDB produtoDB = new ProdutoDB();
        Vendas vendas = new Vendas();

        PrintWriter out = new PrintWriter(System.out);

        out.println("----------MinhaLoja v1.0----------");
        out.flush();


        out.close();
    }
}
