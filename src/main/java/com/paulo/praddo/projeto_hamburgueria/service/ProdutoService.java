package com.paulo.praddo.projeto_hamburgueria.service;

import com.paulo.praddo.projeto_hamburgueria.model.Produto;
import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDTO;
import com.paulo.praddo.projeto_hamburgueria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ResponseEntity salvarNovoProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        produtoRepository.save(produto);

        return ResponseEntity.ok().build();
    }

}
