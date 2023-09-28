package com.paulo.praddo.projeto_hamburgueria.model;

import com.paulo.praddo.projeto_hamburgueria.entity.Produto;


public class Response {

    public ProdutoDATA converter(Produto produto) {
        return new ProdutoDATA(produto.getNome(),produto.getDescricao(),produto.getPreco());
    }
}
