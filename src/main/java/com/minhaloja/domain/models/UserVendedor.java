package com.minhaloja.domain.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserVendedor implements User {
    private String nome;
    private String email;
    private String senha;
    private Set<Venda> vendasRealizadas;

    public UserVendedor(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.vendasRealizadas = new HashSet<>();
    }

    public Set<Venda> getVendasRealizadas() {
        return vendasRealizadas;
    }

    public void addVenda(Venda vendasRealizadas) {
        this.vendasRealizadas.add(vendasRealizadas);
    }

    // GETTERS SETTERS

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVendedor cliente = (UserVendedor) o;
        return Objects.equals(email, cliente.email);
    }
}
