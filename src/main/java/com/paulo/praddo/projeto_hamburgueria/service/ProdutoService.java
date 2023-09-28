package com.paulo.praddo.projeto_hamburgueria.service;

import com.paulo.praddo.projeto_hamburgueria.entity.Produto;
import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDATA;
import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDTO;
import com.paulo.praddo.projeto_hamburgueria.entity.TipoProduto;
import com.paulo.praddo.projeto_hamburgueria.model.Response;
import com.paulo.praddo.projeto_hamburgueria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    Response response = new Response();

    //OK
    public ResponseEntity salvarNovoProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        produtoRepository.save(produto);

        return ResponseEntity.ok().build();
    }

    //OK
    public ProdutoDATA exibirProdutoPeloId(Long idProduto) {
        return response.converter(produtoRepository.findById(idProduto).orElse(null));
    }

    //OK
    public ArrayList<ProdutoDATA> exibirTodosOsProdutos() {
        ArrayList<ProdutoDATA> listaProdutos = new ArrayList<ProdutoDATA>();

        for (Produto produto:
             produtoRepository.findAll()) {
            listaProdutos.add(response.converter(produto));
        }
        return listaProdutos;
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

    public Produto procuraProdutoPeloNome(String nome) {
       return produtoRepository.procuraProdutoPeloNome(nome);
    }

}
