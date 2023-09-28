package com.paulo.praddo.projeto_hamburgueria.repository;

import com.paulo.praddo.projeto_hamburgueria.entity.Pedido;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE PEDIDOS SET CONCLUSAO = :conclusao WHERE id = :id", nativeQuery = true)
    void pedidoConcluido(@Param("id") Long id, @Param("conclusao") String conclusao);
}
