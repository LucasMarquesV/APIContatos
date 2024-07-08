package br.com.lmv.APIContatos.dto;


public class PessoaDTO {
	private Long id;
	private String nome;
	private String contatos;

	public PessoaDTO(Long id, String nome, String contatos) {
        this.id = id;
        this.nome = nome;
        this.contatos = contatos;
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

	public String getContatos() {
		return contatos;
	}

	public void setContatos(String contatos) {
		this.contatos = contatos;
	}
	
}
