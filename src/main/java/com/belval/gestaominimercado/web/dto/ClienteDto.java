package com.belval.gestaominimercado.web.dto;

import java.util.Collection;

import javax.management.relation.Role;

public class ClienteDto {
	
	private Integer id;
	private String aniver;
	private String nome;
	private String email;
	private String senha;
	private String endereco;
	private String cpf;
	
	public ClienteDto() {
		
	}

	public ClienteDto(Integer id, String aniver, String nome, String email, String senha, String endereco, String cpf) {
		super();
		this.id = id;
		this.aniver = aniver;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.cpf = cpf;
	}
	
	public ClienteDto(String aniver, String nome, String email, String senha, String endereco, String cpf) {
		super();
		this.aniver = aniver;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.cpf = cpf;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAniver() {
		return aniver;
	}

	public void setAniver(String aniver) {
		this.aniver = aniver;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	}
