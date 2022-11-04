package com.alessandro.app1;

public class Pet {
	

	private int id;
	private String nome;
	private String raca;
	private int idade;
	
	

	public Pet(int id, String nome, String raca, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public int getIdade() {
		return idade;
	}



	public void setIdade(int idade) {
		this.idade = idade;
	}
	
   public static void main(String[] args) {
	   
	   Pet p= new Pet();
	   p.setId(1);
	   
	   int id= p.getId();
}



public Pet() {
	super();
	// TODO Auto-generated constructor stub
}

}

