package com.paulo.praddo.projeto_hamburgueria.entity;

import com.paulo.praddo.projeto_hamburgueria.model.Conclusao;
import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Conclusao conclusao;

    @Column(name = "DETALHES_PEDIDO")
    private String detalhesPedido;

    @Column(name = "DATA_PEDIDO")
    private Date dataEHoraDoPedido;

    private Double valor;

    public Pedido(String detalhesPedido, Date dataEHoraDoPedido, Double valor) {
        this.detalhesPedido = detalhesPedido;
        this.dataEHoraDoPedido = dataEHoraDoPedido;
        this.valor = valor;
    }

}
