package com.paulo.praddo.projeto_hamburgueria.repository;

import com.paulo.praddo.projeto_hamburgueria.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
