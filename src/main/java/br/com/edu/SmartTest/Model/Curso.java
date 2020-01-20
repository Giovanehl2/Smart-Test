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
@Table(name="Cursos")
public class Curso implements Serializable{
	


	public Curso(long idCurso, String nome, String descricao, List<Aluno> alunos, List<Disciplina> disciplinas) {
		super();
		this.idCurso = idCurso;
		this.nome = nome;
		this.descricao = descricao;
		Alunos = alunos;
		this.disciplinas = disciplinas;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7236042035188244138L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCurso", unique = true, nullable = false)
	@JsonProperty("idCurso")
	private long idCurso;
	
	@Column(name="nome")
	@JsonProperty("nome")
	private String nome;

	@Column(name="descricao")
	@JsonProperty("descricao")
	private String descricao;
	
	
	@ManyToMany(mappedBy = "cursos")
	@JsonProperty("Alunos")
	private List<Aluno> Alunos;
	
	@ManyToMany(mappedBy = "cursos")
	@JsonProperty("disciplinas")
	private List<Disciplina> disciplinas;

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
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

	public List<Aluno> getAlunos() {
		return Alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		Alunos = alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}


	
}
