package br.com.senac.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
	
	@Query("Selec distinct distinct t from Turma t"
			+"Join fetch t.alunos a"
			+"where a.turma.id = ?1")
	List<Turma> findAllByIdTurma(Integer idTurma);
    
}
