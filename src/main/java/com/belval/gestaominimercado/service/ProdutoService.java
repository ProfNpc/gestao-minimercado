package com.belval.gestaominimercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto cadastrar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listar() {
	    return produtoRepository.findAll();
	  }
	public Produto findById(int id) {
		return produtoRepository.findById(id);
	}
}
