package br.com.senac.initialization;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.AlunoCurso;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Endereco;
import br.com.senac.entity.Turma;
import br.com.senac.repository.EnderecoRepository;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.repository.TurmaRepository;
//import br.com.senac.repository.AlunoRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.LivroService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	AlunoService alunoService;
	@Autowired
	CursoService cursoService;
	@Autowired
	TurmaService turmaService;
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private ProfessorRepository profRepository; 
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository; 
	
	@Autowired
	private LivroService livroService;
	
	
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

			
		Curso c1 = new Curso();
		c1.setNome("Java");
		cursoService.salvar(c1);
		
		Curso c2 = new Curso();
		c2.setNome("NodeJS");
		cursoService.salvar(c2);
		
		Curso c3 = new Curso();
		c3.setNome("Python");
		cursoService.salvar(c3);
		
		Curso c4 = new Curso();
		c4.setNome(".Net");
		cursoService.salvar(c4);
		
		
		List<Curso> listaCursos1 = new ArrayList();
		listaCursos1.add(c1);
		listaCursos1.add(c4);
		
		
		List<Curso> listaCursos2 = new ArrayList();
		listaCursos2.add(c2);
		listaCursos2.add(c3);
		
		List<Curso> listaCursos3 = new ArrayList();
		listaCursos2.add(c1);
		listaCursos2.add(c3);
		
		Turma t1 = new Turma();
		t1.setNome("Turma 1");
		t1.setCurso(listaCursos1);
		turmaService.salvar(t1);
		
		Turma t2 = new Turma();
		t2.setNome("Turma 2");
		t2.setCurso(listaCursos2);
		turmaService.salvar(t2);
		
		Turma t3 = new Turma();
		t3.setNome("Turma 3");
		t3.setCurso(listaCursos3);
		turmaService.salvar(t3);
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Leone");
		aluno1.setTurma(t1);
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Rodrigo");
		aluno2.setTurma(t2);
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Ana");
		aluno3.setTurma(t3);
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Walter");
		aluno4.setTurma(t3);
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		
		Avaliacao avaliacao1 = new Avaliacao();
		AlunoCurso alunoCurso1 = new AlunoCurso();
		alunoCurso1.setAluno(aluno1);
		alunoCurso1.setCurso(c4);
		avaliacao1.setAlunoCurso(alunoCurso1);
		avaliacao1.setConceito("I");
		
		avaliacaoService.save(avaliacao1);

		Endereco endereco1 = new Endereco();
		endereco1.setAluno(aluno1);
		endereco1.setBairro("Largo da Batalha");
		endereco1.setCep("24310-460");
		endereco1.setComplemento("Subida do Morro");
		endereco1.setNumero(12);
		endereco1.setRua("Rua João Fonseca");
		
		
		

		
		Aluno al1 = alunoService.buscaPorNome("Leone");
		al1.getEnderecos().forEach((e)-> System.out.println("Rua: " + e.getRua() + "Numero: " +e.getNumero()));
		
	}
}
