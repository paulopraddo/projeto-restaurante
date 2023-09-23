package com.paulo.praddo.projeto_hamburgueria.service;

import com.paulo.praddo.projeto_hamburgueria.model.Produto;
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
        return ResponseEntity.ok(listaDeCompras);
    }

    public ResponseEntity selecionarProdutos(String nomeProduto) {
        listaDeCompras.add(produtoService.procuraProdutoPeloNome(nomeProduto));
        return ResponseEntity.ok(listaDeCompras);
    }


}
