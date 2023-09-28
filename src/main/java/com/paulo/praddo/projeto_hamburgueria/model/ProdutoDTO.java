package com.paulo.praddo.projeto_hamburgueria.model;

import com.paulo.praddo.projeto_hamburgueria.entity.TipoProduto;

public record ProdutoDTO(String nome, String desc, Double preco, TipoProduto tipoProduto) {
}
