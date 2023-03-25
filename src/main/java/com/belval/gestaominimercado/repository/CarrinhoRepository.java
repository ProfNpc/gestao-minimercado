package com.belval.gestaominimercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belval.gestaominimercado.model.ItemCarrinho;

public interface CarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {

}
