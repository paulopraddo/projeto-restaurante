package com.paulo.praddo.projeto_hamburgueria.service;

import com.paulo.praddo.projeto_hamburgueria.entity.Produto;
import com.paulo.praddo.projeto_hamburgueria.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComprasService {

    @Autowired
    ProdutoService produtoService;

    private List<Produto> listaDeCompras = new ArrayList<Produto>();

    public ResponseEntity verItensDoCarrinho() {
        Double valorTotal = (double) 0;
        for (Produto produto: listaDeCompras) {
            valorTotal += produto.getPreco();
        }
        return ResponseEntity.ok(listaDeCompras);
    }

    public Response selecionarProdutos(String nomeProduto) {
        Response response = new Response(produtoService.procuraProdutoPeloNome(nomeProduto));
        listaDeCompras.add(produtoService.procuraProdutoPeloNome(nomeProduto));
        return response;
    }


}
