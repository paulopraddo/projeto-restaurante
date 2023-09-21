package com.paulo.praddo.projeto_hamburgueria.repository;

import com.paulo.praddo.projeto_hamburgueria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
