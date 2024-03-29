package com.belval.gestaominimercado.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Cliente", uniqueConstraints=@UniqueConstraint(columnNames = "email"))
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column (name = "aniver")
	private String aniver;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "senha")
	private String senha;
	@Column(name = "endereco")
	private String endereco;
	@Column (name = "cpf")
	private String cpf;
	
	@OneToMany
	@JoinColumn(name="cliente_id")
	protected List<Carrinho>carrinhos;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			  name="users_roles",
			  joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
			  inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
			)
	private Collection<Role> roles;
	public Cliente() {
	
	}

	public Cliente(Integer id, String aniver, String nome, String email, String senha, String endereco, String cpf, Collection<Role> roles) {
	
		this.id = id;
		this.aniver = aniver;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.cpf = cpf;
		this.roles = roles;
	}
	

	public Cliente( String aniver2, String nome2, String email2, String encode, String endereco2,
			String cpf2, Collection<Role> roles) {
		this.aniver = aniver2;
		this.nome = nome2;
		this.email = email2;
		this.senha = encode;
		this.endereco = endereco2;
		this.cpf = cpf2;
		this.roles = roles;
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
	
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}
}