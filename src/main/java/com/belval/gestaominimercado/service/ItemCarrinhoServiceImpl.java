package com.belval.gestaominimercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belval.gestaominimercado.model.ItemCarrinho;
import com.belval.gestaominimercado.repository.ItemCarrinhoRepository;

@Service
public class ItemCarrinhoServiceImpl implements ItemCarrinhoService {
	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;

	@Override
	public ItemCarrinho save(ItemCarrinho itemCarrinho) {
		return itemCarrinhoRepository.save(itemCarrinho);
	}
	
	@Override
	public List<ItemCarrinho> listarItensCarrinho() {
		return itemCarrinhoRepository.findAll();
	}
}
