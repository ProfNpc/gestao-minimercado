package com.belval.gestaominimercado.service;

import java.util.List;

import com.belval.gestaominimercado.model.ItemCarrinho;

public interface ItemCarrinhoService {
	ItemCarrinho save (ItemCarrinho itemCarrinho);
	List<ItemCarrinho> listarItensCarrinho();
}
