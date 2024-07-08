package br.com.lmv.APIContatos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lmv.APIContatos.dto.PessoaDTO;
import br.com.lmv.APIContatos.model.Pessoa;
import br.com.lmv.APIContatos.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public Pessoa save(Pessoa pessoa) {
		if (pessoa.getNome() == null) {
			System.out.println("Campo de nome da pessoa vazio.");
			return null;
		}

		try {
			return pessoaRepository.save(pessoa);
		} catch (Exception e) {
			System.out.println("Erro ao inserir pessoa " + pessoa.toString() + ": " + e.getMessage());
			return null;
		}
	}

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id);
	}

	public Pessoa update(Pessoa pessoa) {
		Optional<Pessoa> foundPessoa = pessoaRepository.findById(pessoa.getId());

		if (foundPessoa.isPresent()) {
			Pessoa updatedPessoa = foundPessoa.get();
			updatedPessoa.setCep(pessoa.getCep());
			updatedPessoa.setCidade(pessoa.getCidade());
			updatedPessoa.setEndereco(pessoa.getEndereco());
			updatedPessoa.setNome(pessoa.getNome());
			updatedPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updatedPessoa);
		}
		return pessoaRepository.save(pessoa);
	}

	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}

	public PessoaDTO getPessoaWithContatos(Long id) {
		List<Object[]> results = pessoaRepository.findPessoaWithContatos(id);
		PessoaDTO pessoa = convertToPessoaDTO(results);
		
		return pessoa;
	}

	public PessoaDTO convertToPessoaDTO(List<Object[]> results) {
	    if (results.isEmpty()) {
	        return null;
	    }

	    Long id = null;
	    String nome = null;
	    StringBuilder contatosBuilder = new StringBuilder();

	    for (Object[] result : results) {
	        if (id == null) {
	            id = ((Number) result[0]).longValue();
	        }
	        if (nome == null) {
	            nome = (String) result[1];
	        }
	        // Check if result[2] is null and handle accordingly
	        if (result[2] != null) {
	            if (contatosBuilder.length() > 0) {
	                contatosBuilder.append("- ");
	            }
	            contatosBuilder.append((String) result[2]);
	        } else {
	            // Append "contatos not found" if result[2] is null
	            contatosBuilder.append("contatos not found");
	        }
	    }

	    String contatos = contatosBuilder.toString();
	    
	    return new PessoaDTO(id, nome, contatos);
	}

}