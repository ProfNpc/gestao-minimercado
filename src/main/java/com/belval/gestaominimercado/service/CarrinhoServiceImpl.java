package com.belval.gestaominimercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.belval.gestaominimercado.model.Carrinho;
import com.belval.gestaominimercado.model.ItemCarrinho;
import com.belval.gestaominimercado.repository.CarrinhoRepository;
import com.belval.gestaominimercado.repository.ItemCarrinhoRepository;

public class CarrinhoServiceImpl implements CarrinhoService {
	@Autowired
	private CarrinhoRepository carrinhoRepository;

	@Override
	public Carrinho save(Carrinho carrinho) {
		
		return carrinhoRepository.save(carrinho);
	}
}
