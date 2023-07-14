package com.minhaloja;

import com.minhaloja.domain.models.*;
import com.minhaloja.domain.services.ClienteService;
import com.minhaloja.domain.services.ProdutoService;
import com.minhaloja.domain.services.VendaService;
import com.minhaloja.domain.services.VendedorService;
import com.minhaloja.infrastructure.ClienteInMemoryRepository;
import com.minhaloja.infrastructure.ProdutoInMemoryRepository;
import com.minhaloja.infrastructure.VendaInMemoryRepository;
import com.minhaloja.infrastructure.VendedorInMemoryRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ApplicationService {
    private VendedorService vendedorService;
    private ClienteService clienteService;
    private ProdutoService produtoService;
    private VendaService vendaService;

    public ApplicationService(VendedorService vendedorService, ClienteService clienteService, ProdutoService produtoService, VendaService vendaService) {
        this.vendedorService = vendedorService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.vendaService = vendaService;
    }

    public ApplicationService() {
        this.vendedorService = new VendedorService(new VendedorInMemoryRepository());
        this.clienteService = new ClienteService(new ClienteInMemoryRepository());
        this.produtoService = new ProdutoService(new ProdutoInMemoryRepository());
        this.vendaService = new VendaService(
                this.vendedorService,
                this.clienteService,
                this.produtoService,
                new VendaInMemoryRepository()
        );
    }

    public void cadastrarCliente(String nome, String email, String senha) {
        clienteService.update(new UserCliente(nome, email, senha));
    }

    public void cadastrarVendedor(String nome, String email, String senha) {
        vendedorService.update(new UserVendedor(nome, email, senha));
    }

    public void cadastrarVideoGame(Integer id, String nome, BigDecimal preco) {
        produtoService.update(new ProdutoVideoGame(id, nome, preco));
    }

    public void cadastrarVenda(String emailCliente, String emailVendedor, Integer idProduto, BigDecimal preco) {
        vendaService.cadastrarVendaVideoGame(emailCliente, emailVendedor, idProduto, preco);
    }


    public Optional<User> login(String email, String senha) {
        User cliente = clienteService.getByEmail(email);
        if (cliente.getSenha() == senha) {
            return Optional.of(cliente);
        } else return null;
    }

    public String getProdutosString() {
        return produtoService.getAll().toString();
    }

    public Produto getProduto(Integer id){
        return produtoService.getById(id);
    }

    public List<UserVendedor> getVendedores() {
        return vendedorService.getAll();
    }

    public List<UserCliente> getClientes() {
        return clienteService.getAll();
    }
}
