package com.paulo.praddo.projeto_hamburgueria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;

    public Produto(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.nome();
        this.descricao = produtoDTO.desc();
        this.preco = produtoDTO.preco();
        this.tipoProduto = produtoDTO.tipoProduto();
    }

}
