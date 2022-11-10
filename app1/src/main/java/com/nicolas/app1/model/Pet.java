package com.nicolas.app1.model;

public class Pet {
	private int id,idade;
	private String nome,raca;
	
	
	
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pet(int id,int idade,String nome,String raca) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.raca = raca;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public static void main(String[] args) {
		Pet p=new Pet();
		
		int id=p.getId();
		int idade=p.getIdade();
		String nome=p.getNome();
		String raca=p.getRaca();
		
	}
}
