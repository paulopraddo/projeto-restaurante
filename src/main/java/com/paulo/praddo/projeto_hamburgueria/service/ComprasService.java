package com.paulo.praddo.projeto_hamburgueria.service;

import com.paulo.praddo.projeto_hamburgueria.entity.Produto;
import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDATA;
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

    Response response = new Response();

    private List<Produto> listaDeCompras = new ArrayList<Produto>();

    public ArrayList<ProdutoDATA> verItensDoCarrinho() {
        ArrayList<ProdutoDATA> listaProdutos = new ArrayList<ProdutoDATA>();

        for (Produto produto:
                listaDeCompras) {
            listaProdutos.add(response.converter(produto));
        }
        return listaProdutos;
    }

    public ProdutoDATA selecionarProdutos(String nomeProduto) {
        Produto produto = produtoService.procuraProdutoPeloNome(nomeProduto);
        listaDeCompras.add(produto);
        return response.converter(produto);
    }


}