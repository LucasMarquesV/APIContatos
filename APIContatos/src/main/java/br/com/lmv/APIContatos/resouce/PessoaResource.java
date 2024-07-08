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

import br.com.lmv.APIContatos.dto.PessoaDTO;
import br.com.lmv.APIContatos.model.Pessoa;
import br.com.lmv.APIContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

	@Autowired
	PessoaService pessoaService;
	
	@Operation(summary = "Busca todos os registros de pessoas cadastradas")
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAllPessoas(){
		List<Pessoa> pessoas = pessoaService.findAll();
		if(pessoas == null || pessoas.size() == 0 || pessoas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);
	}
	
	@Operation(summary = "Busca registro de pessoa por meio do Id")
	@GetMapping ("/{id}")
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		if(pessoa == null || pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoa);
	}
	
	@Operation(summary = "Insere um novo registro de pessoa")
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		Pessoa newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(newPessoa);
	}
	
	@Operation(summary = "Atualiza um registro de pessoa")
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		Pessoa updatedPessoa = pessoaService.update(pessoa);
		if(updatedPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(updatedPessoa);
		}
	}
	
	@Operation(summary = "Apaga um registro de pessoa por meio do Id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Operation(summary = "Busca um registro de pessoa e exibe apenas seu nome e seus telefones cadastrados")
	@GetMapping("/pessoaDTO/{id}") //http://localhost:8081/api/produtos/produtoAndQte/ 
	public  ResponseEntity<PessoaDTO> /*ResponseEntity<Optional<PessoaDTO>>*/ findPessoaWithContatos(@PathVariable Long id){
		PessoaDTO pessoaDTO = pessoaService.getPessoaWithContatos(id);
		if(pessoaDTO != null) {
		return ResponseEntity.ok(pessoaDTO);
		}
		else return ResponseEntity.notFound().build();
	}
}