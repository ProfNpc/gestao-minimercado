package com.belval.gestaominimercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belval.gestaominimercado.model.ItemCarrinho;
import com.belval.gestaominimercado.repository.ItemCarrinhoRepository;

@Service
public class ItemCarrinhoService {
	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;

	public List<ItemCarrinho> findAll() {
		return itemCarrinhoRepository.findAll();
	}

	public ItemCarrinho findById(long idIt) {
		return itemCarrinhoRepository.findById(idIt);
	}
}
