package com.belval.gestaominimercado.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belval.gestaominimercado.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	  List<Produto> findByDescricao(String descricao);

	  Produto findById(int id);
}
