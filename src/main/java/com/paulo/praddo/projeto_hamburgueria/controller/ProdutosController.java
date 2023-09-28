package com.paulo.praddo.projeto_hamburgueria.controller;

import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDTO;
import com.paulo.praddo.projeto_hamburgueria.entity.TipoProduto;
import com.paulo.praddo.projeto_hamburgueria.service.ComprasService;
import com.paulo.praddo.projeto_hamburgueria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ComprasService comprasService;

    @GetMapping
    public String paginaInicial() {
        return "restaurante/cardapio";
    }

    @PostMapping("/salvarNovoProduto")
    public ResponseEntity salvarNovoProduto(@RequestBody ProdutoDTO produtoDTO) {
        return this.produtoService.salvarNovoProduto(produtoDTO);
    }

    @GetMapping("/exibeProduto/id/{idProduto}")
    public ResponseEntity exibeProdutoPeloId(@PathVariable Long idProduto) {
        return this.produtoService.exibirProdutoPeloId(idProduto);
    }

    @GetMapping("/exibeTodosOsProdutos")
    public ResponseEntity exibeTodosOsProdutos() {
        return this.produtoService.exibirTodosOsProdutos();
    }

    @PutMapping("/alterarNome/id/{idProduto}/nome/{newNome}")
    public ResponseEntity alterarNomeProduto(@PathVariable Long idProduto, @PathVariable String newNome) {
        return this.produtoService.alterarNomeProduto(idProduto, newNome);
    }

    @PutMapping("/alterarDesc/id/{idProduto}/desc/{newDesc}")
    public ResponseEntity alterarDescProduto(@PathVariable Long idProduto, @PathVariable String newDesc) {
        return this.produtoService.alterarDescProduto(idProduto, newDesc);
    }

    @PutMapping("/alterarPreco/id/{idProduto}/preco/{newPreco}")
    public ResponseEntity alterarPrecoProduto(@PathVariable Long idProduto, @PathVariable Double newPreco) {
        return this.produtoService.alterarPrecoProduto(idProduto, newPreco);
    }

    @PutMapping("/alterarTipo/id/{idProduto}/tipo/{newTipo}")
    public ResponseEntity alterarTipoProduto(@PathVariable Long idProduto, @PathVariable TipoProduto newTipo) {
        return this.produtoService.alterarTipoProduto(idProduto, newTipo);
    }
}
