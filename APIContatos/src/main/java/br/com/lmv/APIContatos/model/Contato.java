package br.com.lmv.APIContatos.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer tipo;
	
	@Column(nullable = false)
	private String contato;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	@JsonBackReference
	private Pessoa pessoa;
	
	public Contato() {}
	public Contato(Long id, Integer tipo, String contato, Pessoa pessoa) {
		this.id = id;
		this.tipo = tipo;
		this.contato = contato;
		this.pessoa = pessoa;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(contato, id, pessoa, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(contato, other.contato) && Objects.equals(id, other.id)
				&& Objects.equals(pessoa, other.pessoa) && Objects.equals(tipo, other.tipo);
	}
	@Override
	public String toString() {
		return "Contato [id=" + id + 
				", tipo=" + tipo + "]";
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}