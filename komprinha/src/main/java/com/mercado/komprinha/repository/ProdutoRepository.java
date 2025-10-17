package com.mercado.komprinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mercado.komprinha.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
