package com.minhaloja.domain.services;

import com.minhaloja.domain.models.Produto;
import com.minhaloja.domain.models.UserCliente;
import com.minhaloja.domain.models.UserVendedor;
import com.minhaloja.domain.models.Venda;
import com.minhaloja.domain.repositories.VendaRepository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class VendaService {
    private VendedorService vendedorService;
    private ClienteService clienteService;
    private ProdutoService produtoService;
    private VendaRepository vendaRepository;

    public VendaService(VendedorService vendedorService, ClienteService clienteService, ProdutoService produtoService, VendaRepository vendaRepository) {
        this.vendedorService = vendedorService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.vendaRepository = vendaRepository;
    }

    public Venda cadastrarVendaVideoGame(String emailCliente, String emailVendedor, Integer idProduto, BigDecimal valorVenda) {
        UserCliente cliente = clienteService.getByEmail(emailCliente);
        UserVendedor vendedor = vendedorService.getByEmail(emailVendedor);
        Produto produto = produtoService.getById(idProduto);

        Venda venda = new Venda(cliente, vendedor, produto, valorVenda);
        Venda vendaRegistrada = vendaRepository.gravar(venda);

        cliente.addCompra(vendaRegistrada);
        vendedor.addVenda(vendaRegistrada);
        vendedorService.update(vendaRegistrada.getVendedor());
        clienteService.update(vendaRegistrada.getCliente());

        return vendaRegistrada;
    }

    public Venda getById(Integer id) {
        return vendaRepository.getByID(id).orElseThrow(
                () -> new NoSuchElementException("Venda de ID " + id + " não encontrada")
        );
    }

    public List<Venda> getAll() {
        return Collections.unmodifiableList(vendaRepository.getAll());
    }
}
