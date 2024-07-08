package br.com.lmv.APIContatos.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false) 
private String nome;

@Column(nullable = true)
private String endereco;

@Column(nullable = true)
private String cep;

@Column(nullable = true)
private String cidade;

@Column(nullable = true)
private String uf;

@OneToMany
@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
@JsonManagedReference
private List<Contato> contato;

public Pessoa() {}

public Pessoa(Long id, String nome, String endereco, String cep, String cidade, String uf, List<Contato> contato) {
	super();
	this.id = id;
	this.nome = nome;
	this.endereco = endereco;
	this.cep = cep;
	this.cidade = cidade;
	this.uf = uf;
	this.contato = contato;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep;
}

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public String getUf() {
	return uf;
}

public void setUf(String uf) {
	this.uf = uf;
}

public List<Contato> getContato() {
	return contato;
}

public void setContato(List<Contato> contato) {
	this.contato = contato;
}

@Override
public int hashCode() {
	return Objects.hash(cep, cidade, contato, endereco, id, nome, uf);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pessoa other = (Pessoa) obj;
	return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
			&& Objects.equals(contato, other.contato) && Objects.equals(endereco, other.endereco)
			&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(uf, other.uf);
}



}