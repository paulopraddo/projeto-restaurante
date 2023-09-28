package com.paulo.praddo.projeto_hamburgueria.controller;


import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDATA;
import com.paulo.praddo.projeto_hamburgueria.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public ArrayList<ProdutoDATA> exibirCarrinho() {
        return comprasService.verItensDoCarrinho();
    }

    @PostMapping("/finalizarPedido")
    public ResponseEntity finalizarPedido() {
        return comprasService.realizarPedido();
    }

    @PutMapping("/concluirPedido/{idPedido}")
    public ResponseEntity concluirPedido(@PathVariable Long idPedido) {
        return comprasService.pedidoConcluido(idPedido);
    }
}
