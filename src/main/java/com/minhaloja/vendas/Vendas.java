package com.minhaloja.vendas;

import java.io.File;
import java.io.IOException;

public class Vendas {
    private File vendasLog;

    public Vendas(){
        try {
            this.vendasLog = File.createTempFile("vendasLog", "txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
