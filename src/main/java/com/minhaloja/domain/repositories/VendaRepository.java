package com.minhaloja.domain.repositories;

import com.minhaloja.domain.models.Venda;

import java.util.List;
import java.util.Optional;

public interface VendaRepository {
    Venda gravar(Venda venda);
    List<Venda> getAll();
    Optional<Venda> getByID(Integer id);
}
