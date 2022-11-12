package com.belval.gestaominimercado.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belval.gestaominimercado.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
	
	  List<Produto> findByDescricao(String descricao);

	  Produto findById(int id);
}
