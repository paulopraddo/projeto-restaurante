package com.paulo.praddo.projeto_hamburgueria.service;

import com.paulo.praddo.projeto_hamburgueria.model.Produto;
import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDTO;
import com.paulo.praddo.projeto_hamburgueria.model.TipoProduto;
import com.paulo.praddo.projeto_hamburgueria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    //OK
    public ResponseEntity salvarNovoProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        produtoRepository.save(produto);

        return ResponseEntity.ok().build();
    }

    //OK
    public ResponseEntity exibirProdutoPeloId(Long idProduto) {
        return ResponseEntity.ok(produtoRepository.findById(idProduto));
    }

    //OK
    public ResponseEntity exibirTodosOsProdutos() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    public ResponseEntity alterarNomeProduto(Long idProduto, String newNome) {
        this.produtoRepository.atualizarNomeProduto(idProduto,newNome);
        return ResponseEntity.ok(produtoRepository.findById(idProduto));
    }

    public ResponseEntity alterarDescProduto(Long idProduto, String desc) {
        this.produtoRepository.atualizarDescProduto(idProduto,desc);
        return ResponseEntity.ok(produtoRepository.findById(idProduto));
    }

    public ResponseEntity alterarPrecoProduto(Long idProduto, Double preco) {
        this.produtoRepository.atualizarPrecoProduto(idProduto, preco);
        return ResponseEntity.ok(produtoRepository.findById(idProduto));
    }

    public ResponseEntity alterarTipoProduto(Long idProduto, TipoProduto tipoProduto) {
        this.produtoRepository.atualizarTipoProduto(idProduto, tipoProduto.toString());
        return ResponseEntity.ok(produtoRepository.findById(idProduto));
    }


}
