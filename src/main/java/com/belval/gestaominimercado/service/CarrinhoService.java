package com.belval.gestaominimercado.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belval.gestaominimercado.model.Carrinho;
import com.belval.gestaominimercado.model.ItemCarrinho;

@Service
public interface CarrinhoService {
	Carrinho save (Carrinho carrinho);

	Carrinho findByStatus(String Status);
}
