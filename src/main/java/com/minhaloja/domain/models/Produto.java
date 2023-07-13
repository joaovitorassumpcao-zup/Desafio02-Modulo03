package com.minhaloja.domain.models;

import java.math.BigDecimal;

public interface Produto {
    Integer getID();
    String getNome();
    Venda vender(UserCliente cliente, UserVendedor vendedor, BigDecimal valor);
}
