package br.com.edu.SmartTest.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Alunos")
public class Aluno implements Serializable {

		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAluno", unique = true, nullable = false)
	private long idAluno;

	@Column(name = "matricula")
	private int matricula;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "senha")
	private String senha;
	
	@ManyToMany
	private List<Curso> Curso;

	
	@ManyToMany
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


	public List<Curso> getCurso() {
		return Curso;
	}


	public void setCurso(List<Curso> curso) {
		Curso = curso;
	}


	public List<Turma> getTurmas() {
		return turmas;
	}


	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
