package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.AlunoCurso;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, AlunoCurso> {
	
	

}
