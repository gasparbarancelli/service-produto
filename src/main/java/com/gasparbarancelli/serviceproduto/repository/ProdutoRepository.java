package com.gasparbarancelli.serviceproduto.repository;

import com.gasparbarancelli.serviceproduto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
