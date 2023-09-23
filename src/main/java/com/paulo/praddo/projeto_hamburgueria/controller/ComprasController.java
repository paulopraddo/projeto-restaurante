package com.paulo.praddo.projeto_hamburgueria.controller;

import com.paulo.praddo.projeto_hamburgueria.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    ComprasService comprasService;


    @PostMapping("/adicionarAoCarrinho/{nomeProduto}")
    public ResponseEntity adicionarProdutosAoCarrinho(@PathVariable String nomeProduto) {
        return ResponseEntity.ok(this.comprasService.selecionarProdutos(nomeProduto));
    }

    @GetMapping("/exibirCarrinho")
    public ResponseEntity exibirCarrinho() {
        return comprasService.verItensDoCarrinho();
    }
}
