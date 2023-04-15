package com.belval.gestaominimercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belval.gestaominimercado.model.Carrinho;
import com.belval.gestaominimercado.model.Produto;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

	void delete(Carrinho carrinho);
	
}
