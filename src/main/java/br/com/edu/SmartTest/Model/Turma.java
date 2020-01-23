package br.com.edu.SmartTest.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="Turmas")
public class Turma implements Serializable{

	private static final long serialVersionUID = -7600635712824313274L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTurma", unique = true, nullable = false)
	@JsonProperty("idTurma")
	private long idTurma;

	@Column(name="nome")
	@JsonProperty("nome")
	private String nome;
	
	@Column(name="semestre")
	@JsonProperty("semestre")
	private String semestre;
	
	@Column(name="ano")
	@JsonProperty("ano")
	private String ano;
	
	
	@ManyToMany(mappedBy = "turmas")
	@JsonProperty("disciplinas")
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@ManyToMany(mappedBy = "turmas")
	@JsonProperty("alunos")
	private List<Aluno> alunos = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "idTurma")
	@JsonProperty("provas")
    private List<Prova> provas = new ArrayList<>();

	public long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(long idTurma) {
		this.idTurma = idTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

}
