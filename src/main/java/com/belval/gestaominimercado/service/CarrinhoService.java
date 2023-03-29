package com.belval.gestaominimercado.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belval.gestaominimercado.model.ItemCarrinho;
import com.belval.gestaominimercado.model.Produto;
import com.belval.gestaominimercado.repository.CarrinhoRepository;
import com.belval.gestaominimercado.repository.ProdutoRepository;

@Service
public class CarrinhoService {
	
	private CarrinhoRepository carrinhoRepository;
    private ProdutoRepository produtoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoRepository;
    }

    //public void adicionarItemCarrinho(int id) {
  //      Produto produto = produtoRepository.findById(id);
//
    //    ItemCarrinho itemCarrinho = new ItemCarrinho(int);
  //      itemCarrinho.setProduto(produto);
//
      //  carrinhoRepository.save(itemCarrinho);
    //}

    public List<ItemCarrinho> listarItensCarrinho() {
        return carrinhoRepository.findAll();
    }
}
