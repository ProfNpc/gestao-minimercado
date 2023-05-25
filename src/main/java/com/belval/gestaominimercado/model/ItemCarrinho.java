package com.belval.gestaominimercado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_carrinho")
public class ItemCarrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	
	@ManyToOne
	@JoinColumn(name = "carrinho_id")
	@JsonIgnore
	private Carrinho carrinho;
	
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	@JsonIgnore
	private Produto produto;
	
	private int quantidade;
	@Column (name="preco_unitario")
	private double precoUnitario;
	private double precoTotal;
	private double desconto;
	
	public ItemCarrinho() {
	
	}

	public ItemCarrinho( Produto produto,  int quantidade, double precoUnitario, double desconto, double precoTotal) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.desconto = desconto;
		this.precoTotal = precoTotal;
	}
	
	public ItemCarrinho( Produto produto,  int quantidade, double precoUnitario, double desconto, Carrinho carrinho) {
		this.produto = produto;
		this.carrinho = carrinho;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.desconto = desconto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double getDesconto() {
		return desconto;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
}
