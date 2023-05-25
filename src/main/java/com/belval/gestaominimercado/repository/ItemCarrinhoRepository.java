package com.belval.gestaominimercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belval.gestaominimercado.model.ItemCarrinho;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
	
	ItemCarrinho findById(long id);
	ItemCarrinho findById2(long id2);

}
