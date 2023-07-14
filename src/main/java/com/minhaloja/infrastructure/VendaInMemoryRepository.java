package com.minhaloja.infrastructure;

import com.minhaloja.domain.models.Venda;
import com.minhaloja.domain.repositories.VendaRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VendaInMemoryRepository implements VendaRepository {
    private List<Venda> dataBase;

    private static Integer GERADOR_ID = 0;

    public VendaInMemoryRepository() {
        this.dataBase = new ArrayList<>();
    }

    @Override
    public Venda gravar(Venda venda) {
        Venda vendaGerada = new Venda(GERADOR_ID++, venda);
        dataBase.add(vendaGerada);
        return vendaGerada;
    }

    @Override
    public List<Venda> getAll() {
        return Collections.unmodifiableList(dataBase);
    }

    @Override
    public Optional<Venda> getByID(Integer id) {
        return dataBase.stream().filter(
                v -> v.getId().equals(id)
        ).findFirst();
    }
}
