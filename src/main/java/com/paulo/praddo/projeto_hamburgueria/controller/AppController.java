package com.paulo.praddo.projeto_hamburgueria.controller;

import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDTO;
import com.paulo.praddo.projeto_hamburgueria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity paginaInicial() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/salvarNovoProduto")
    public ResponseEntity salvarNovoProduto(@RequestBody ProdutoDTO produtoDTO) {
        return this.produtoService.salvarNovoProduto(produtoDTO);
    }
}
