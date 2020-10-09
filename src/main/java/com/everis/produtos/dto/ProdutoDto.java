package com.everis.produtos.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDto {

    private Long id;
    private String nome;
    private BigDecimal quantidade;
    private BigDecimal valor;
}
