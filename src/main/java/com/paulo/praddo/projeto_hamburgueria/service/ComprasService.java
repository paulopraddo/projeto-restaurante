package com.paulo.praddo.projeto_hamburgueria.service;

import com.paulo.praddo.projeto_hamburgueria.entity.Pedido;
import com.paulo.praddo.projeto_hamburgueria.entity.Produto;
import com.paulo.praddo.projeto_hamburgueria.model.Conclusao;
import com.paulo.praddo.projeto_hamburgueria.model.ProdutoDATA;
import com.paulo.praddo.projeto_hamburgueria.model.Response;
import com.paulo.praddo.projeto_hamburgueria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ComprasService {

    @Autowired
    PedidoRepository pedidoRepository;

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

    public ResponseEntity realizarPedido() {

        String detalhesPedido = "";
        Double valor = 3.99;

        for (Produto produto:
                listaDeCompras) {
            detalhesPedido += "/ " + produto.getNome() + " /";
        }

        for (Produto produto:
                listaDeCompras) {
            valor += produto.getPreco();
        }

        Pedido pedido = new Pedido(detalhesPedido,new Date(),valor);
        pedidoRepository.save(pedido);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity pedidoConcluido(Long idPedido) {
        pedidoRepository.pedidoConcluido(idPedido, Conclusao.CONCLUIDO.toString());
        return ResponseEntity.ok().build();
    }

}