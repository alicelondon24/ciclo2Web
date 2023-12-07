package br.com.senac.entity;

import java.io.Serializable;

import javax.persistence.ManyToOne;

public class AlunoCurso implements Serializable{
	private static final long serialVersionUID = 6631457942567742474L;
	
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Curso curso;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	


}
