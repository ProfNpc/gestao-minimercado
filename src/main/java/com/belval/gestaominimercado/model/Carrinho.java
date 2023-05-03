package com.belval.gestaominimercado.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "carrinhos")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double valor;
	
	@Column (name="data_compra")
	@CreationTimestamp
	private LocalDateTime dataCompra;
	
	@Column (name="status_carrinho")
	private String statusCarrinho;
	
	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
	private List<ItemCarrinho> itensCarrinho = new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	//@ManyToOne
  //  private Produto produto;
	
	public Carrinho() {
		
	}
	
	public Carrinho(double valor,  String statusCarrinho) {
		
		this.valor = valor;
		this.statusCarrinho = statusCarrinho;
		
	}

	//public Carrinho(int id2) {
		// TODO Auto-generated constructor stub
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getStatusCarrinho() {
		return statusCarrinho;
	}

	public void setStatusCarrinho(String statusCarrinho) {
		this.statusCarrinho = statusCarrinho;
	}



	public List<ItemCarrinho> getItensCarrinho() {
		return itensCarrinho;
	}

	public void setItensCarrinho(List<ItemCarrinho> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
}
