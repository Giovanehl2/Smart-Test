package br.com.edu.SmartTest.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="Turmas")
public class Turma implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTurma", unique = true, nullable = false)
	private long idTurma;

	@Column(name="nome")
	private String nome;
	
	@Column(name="semestre")
	private String semestre;
	
	@Column(name="ano")
	private String ano;
	
	
	@ManyToMany
	private List<Disciplina> disciplinas;
	
	@ManyToMany
	private List<Aluno> alunos;
	
	@OneToMany
    private List<Prova> provas;

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
