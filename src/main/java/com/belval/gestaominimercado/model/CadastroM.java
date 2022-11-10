package com.belval.gestaominimercado.model;

public class CadastroM {
	
	private String fantasia; /*nome*/
	private String email;
	private String senha;
	private String endereco;
	private String tipo; /*mercado*/
	private int telefone; /*contato*/
	private String cnpj;
	
	public CadastroM(String fantasia, String email, String senha, String endereco, String tipo, int telefone, String cnpj) {
		super();
		this.fantasia = fantasia;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.tipo = tipo;
		this.telefone = telefone;
		this.cnpj = cnpj;
		
		// TODO Auto-generated constructor stub
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	

}
