package com.paulo.praddo.projeto_hamburgueria.repository;

import com.paulo.praddo.projeto_hamburgueria.entity.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRODUTO SET NOME = :nome WHERE id = :id", nativeQuery = true)
    void atualizarNomeProduto(@Param("id") Long id, @Param("nome") String nome);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRODUTO SET DESCRICAO = :desc WHERE id = :id", nativeQuery = true)
    void atualizarDescProduto(@Param("id") Long id, @Param("desc") String desc);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRODUTO SET PRECO = :preco WHERE id = :id", nativeQuery = true)
    void atualizarPrecoProduto(@Param("id") Long id, @Param("preco") Double preco);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PRODUTO SET TIPO = :tipo WHERE id = :id", nativeQuery = true)
    void atualizarTipoProduto(@Param("id") Long id, @Param("tipo") String tipoProduto);


    @Query(value = "SELECT p FROM Produto p WHERE p.nome = :nome")
    Produto procuraProdutoPeloNome(@Param("nome") String nome);

}

