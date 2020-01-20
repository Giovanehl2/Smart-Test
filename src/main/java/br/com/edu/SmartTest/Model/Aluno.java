package br.com.edu.SmartTest.Model;

import java.io.Serializable;
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
@Table(name="Alunos")
public class Aluno implements Serializable {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = -7721140114551319452L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAluno", unique = true, nullable = false)
	@JsonProperty("idAluno")
	private long idAluno;

	@Column(name = "matricula")
	@JsonProperty("matricula")
	private int matricula;

	@Column(name = "nome")
	@JsonProperty("nome")
	private String nome;

	@Column(name = "sexo")
	@JsonProperty("sexo")
	private String sexo;

	@Column(name = "senha")
	@JsonProperty("senha")
	private String senha;
	

	@ManyToMany
	@JoinTable(name = "cursos_alunos")
	@JsonProperty("cursos")
	private List<Curso> cursos;

	@ManyToMany
	@JoinTable(name = "turmas_alunos")
	@JsonProperty("turmas")
	private List<Turma> turmas;


	public long getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}


	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}




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
