package com.belval.gestaominimercado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.belval.gestaominimercado.model.ItemCarrinho;
import com.belval.gestaominimercado.repository.ItemCarrinhoRepository;

public class ItemCarrinhoService {
	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;

	public List<ItemCarrinho> findAll() {
		return itemCarrinhoRepository.findAll();
	}

	public ItemCarrinho findById(Long id) {
		Optional<ItemCarrinho> obj = itemCarrinhoRepository.findById(id);
		return obj.get();
	}
}
