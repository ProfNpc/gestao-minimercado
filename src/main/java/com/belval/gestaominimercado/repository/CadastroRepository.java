package com.belval.gestaominimercado.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belval.gestaominimercado.model.Cliente;

public interface CadastroRepository extends CrudRepository<Cliente, Integer> {
	
	  List<Cliente> findByDescricao(String descricao);

	  Cliente findById(int id);
}
