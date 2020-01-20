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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Professores")
public class Professor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4827112727112617592L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProfessor", unique = true, nullable = false)
	@JsonProperty("")
	private long idProfessor;

	@Column(name="matricula")
	@JsonProperty("")
	private int matricula;
	
	@Column(name="nome")
	@JsonProperty("")
	private String nome;
	
	@Column(name="sexo")
	@JsonProperty("")
	private String sexo;
	
	@Column(name="senha")
	@JsonProperty("")
	private String senha;

	@ManyToMany(mappedBy = "professores")
	@JsonProperty("")
	private List<Disciplina> disciplinas;

	public long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(long idProfessor) {
		this.idProfessor = idProfessor;
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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}


	
}
