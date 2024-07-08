package br.com.lmv.APIContatos.resouce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lmv.APIContatos.model.Contato;
import br.com.lmv.APIContatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {
	
	@Autowired
	private ContatoService contatoService;
	
	@Operation(summary = "Insere um novo registro de contato")
	@PostMapping
	public ResponseEntity<Contato> save(@RequestBody Contato contato){
		Contato newContato = contatoService.save(contato);
		if(newContato == null) {
			return ResponseEntity.notFound().build();
			}
		return ResponseEntity.ok(newContato);
	}
	
	@Operation(summary = "Busca registro de contato por meio do Id")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato= contatoService.findById(id);
		if(findContato == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(findContato);
	}
	
	@Operation(summary = "Busca todos os registros de contatos cadastradas")
	@GetMapping
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> contatos = contatoService.findAll();
		if(contatos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contatos);
	}
	
	@Operation(summary = "Atualiza um registro de um contato")
	@PutMapping
	public ResponseEntity<Contato> update(@RequestBody Contato contato){
		Contato updatedContato = contatoService.update(contato);
		if(updatedContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contato);
	}
	
	@Operation(summary = "Apaga um registro de um contato por meio do Id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
