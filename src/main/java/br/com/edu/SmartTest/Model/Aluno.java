package br.com.edu.SmartTest.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Alunos")
public class Aluno extends Pessoa implements Serializable {

	private static final long serialVersionUID = -7721140114551319452L;


	@ManyToMany
	@JoinTable(name = "cursos_alunos")
	@JsonProperty("cursos")
	private List<Curso> cursos = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "turmas_alunos")
	@JsonProperty("turmas")
	private List<Turma> turmas = new ArrayList<>();


	public List<Turma> getTurmas() {
		return turmas;
	}


	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}


	public List<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}


}
