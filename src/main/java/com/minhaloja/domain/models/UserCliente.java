package com.minhaloja.domain.models;

import java.util.HashSet;
import java.util.Set;

public class UserCliente implements User{
    private String nome;
    private String email;
    private String senha;
    private Set<Venda> comprasRealizadas;

    public UserCliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.comprasRealizadas = new HashSet<>();
    }

    public void addCompra(Venda venda) {
        this.comprasRealizadas.add(venda);
    }

    public Set<Venda> getComprasRealizadas() {
        return comprasRealizadas;
    }

    // GETTERS E SETTERS

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }
}
