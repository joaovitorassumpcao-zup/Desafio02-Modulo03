package com.minhaloja.vendas;

import com.minhaloja.produtos.Produto;
import com.minhaloja.usuarios.Cliente;

import java.io.*;

public class Vendas {
    private File vendasLog;

    public Vendas(){
        this.vendasLog = new File("vendasLog.txt");
    }

    public File getVendasLog() {
        return vendasLog;
    }

    public void addVenda(Produto produto, Cliente cliente) throws IOException {
        try(FileWriter fileWriter = new FileWriter(this.vendasLog, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter out = new PrintWriter(bufferedWriter))
        {
            out.append("Compra por '" + cliente.getEmail() +
                    "' do produto de ID:" + produto.getId() +
                    " vendido por " + produto.getVendedor());
        } catch (IOException e) {
            throw e;
        }
    }
}
