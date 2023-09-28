package com.paulo.praddo.projeto_hamburgueria.model;

import com.paulo.praddo.projeto_hamburgueria.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private ProdutoDATA data;

    private String message;

    private HttpStatus httpStatus;

    public ProdutoDATA converter(Produto produto) {
        ProdutoDATA data = new ProdutoDATA(produto.getNome(),produto.getDescricao(),produto.getPreco());
        return data;
    }

    public Response(Produto produto) {
        this.data = converter(produto);
        this.message = "Ok";
        this.httpStatus = HttpStatus.OK;
    }
}
