package com.belval.gestaominimercado.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
private List<Produto> produtosSelecionados;
    
    public Carrinho() {
        this.produtosSelecionados = new ArrayList<>();
    }
    
    public List<Produto> getProdutosSelecionados() {
        return produtosSelecionados;
    }
    
    public void adicionarProduto(Produto produto) {
        this.produtosSelecionados.add(produto);
    }
    
    public void removerProduto(Produto produto) {
        this.produtosSelecionados.remove(produto);
    }
}
