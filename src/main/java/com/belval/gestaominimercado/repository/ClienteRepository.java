package com.belval.gestaominimercado.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belval.gestaominimercado.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
	  List<Cliente> findByNome(String nome);

	  Cliente findById(int id);
}
