package br.com.lmv.APIContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lmv.APIContatos.model.Contato;
import br.com.lmv.APIContatos.model.Pessoa;
import br.com.lmv.APIContatos.repository.ContatoRepository;
import br.com.lmv.APIContatos.repository.PessoaRepository;
import br.com.lmv.APIContatos.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService implements ContatoServiceInterface{

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Contato save(Contato contato) {
		if(contato.getPessoa().getId() != null) {
			Optional<Pessoa> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			if(!findPessoa.isEmpty()) {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}else {
				System.out.println("Pessoa não encontrada, id = " + contato.getPessoa().getId());
				return null;
			}
		}else { 
			System.out.println("Pessoa não encontrada.");
		}
		return null;
	}

	@Override
	public Optional<Contato> findById(Long id) {
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}

	@Override
	public Contato update(Contato contato) {
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		if(findContato.isPresent()) {
			Contato updatedContato = findContato.get();
			updatedContato.setTipo(contato.getTipo());
			updatedContato.setContato(contato.getContato());
			
			return contatoRepository.save(updatedContato);
		} else {
			return save(contato);
		}
		
		
	}

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
}
