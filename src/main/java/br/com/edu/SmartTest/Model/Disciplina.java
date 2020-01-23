package br.com.edu.SmartTest.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Disciplinas")
public class Disciplina implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2296171009290042391L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDisciplina", unique = true, nullable = false)
	@JsonProperty("idDisciplina")
	private long idDisciplina;
	
	@Column(name="nome")
	@JsonProperty("nome")
	private String nome;
	
	@Column(name="descricao")
	@JsonProperty("descricao")
	private String descricao;
	

	@ManyToMany
	@JoinTable(name = "cursos_disciplinas")
	@JsonProperty("cursos")
	private List<Curso> cursos;
		
	@ManyToMany
	@JoinTable(name = "provas_disciplinas")
	@JsonProperty("provas")
	private List<Prova> provas;
	
	@ManyToMany
	@JoinTable(name = "turmas_disciplinas")
	@JsonProperty("turmas")
	private List<Turma> turmas;
	
	@ManyToMany
	@JoinTable(name = "perguntas_disciplinas")
	@JsonProperty("perguntas")
	private List<Pergunta> perguntas = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "respostas_disciplinas")
	@JsonProperty("respostas")
	private List<Resposta> respostas = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "professores_disciplinas")
	@JsonProperty("professores")
	private List<Professor> professores = new ArrayList<>();
	
	public long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
}
