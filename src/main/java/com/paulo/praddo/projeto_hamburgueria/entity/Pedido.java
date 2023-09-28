package com.paulo.praddo.projeto_hamburgueria.entity;

import com.paulo.praddo.projeto_hamburgueria.model.Conclusao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Conclusao conclusao;

    private String detalhesPedido;

    private Double valor;

}
