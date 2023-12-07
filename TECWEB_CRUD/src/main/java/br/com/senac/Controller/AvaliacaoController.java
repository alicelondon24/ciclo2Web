package br.com.senac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Avaliacao;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;

public class AvaliacaoController {
	@Autowired
	AlunoService alunoService;
	@Autowired
	CursoService cursoService;
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@GetMapping("/adiciona")
	
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("avaliacoes/inserir-nota");
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		mv.addObject("avaliacao", new Avaliacao());
		
		return mv;
	}
	
	@PostMapping
	public ModelAndView save (@ModelAttribute("avaliacao") Avaliacao avaliacao) {
		avaliacao.getAlunoCurso().setAluno(alunoService.buscarAlunoId(avaliacao.getAlunoCurso().getCurso().getId()));
		avaliacao.getAlunoCurso().setCurso(cursoService.buscarCursoId(avaliacao.getAlunoCurso().getCurso().getId()));
		ModelAndView mv = new ModelAndView("avaliacoes/listar-notas");
		mv.addObject("avaliacoes", avaliacaoService.findAll());
		return mv;
	}

}
