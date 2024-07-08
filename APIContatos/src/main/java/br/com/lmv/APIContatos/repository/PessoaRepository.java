package br.com.lmv.APIContatos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lmv.APIContatos.model.Pessoa;

@Repository 
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	@Query(value = "SELECT p.id, p.nome, c.contato FROM tb_pessoa p INNER JOIN tb_contato c ON p.id = c.pessoa_id WHERE p.id = :id",
		       nativeQuery = true)
	List<Object[]> findPessoaWithContatos(@Param("id") Long id);
}
