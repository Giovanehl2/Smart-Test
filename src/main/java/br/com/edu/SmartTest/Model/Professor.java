package br.com.edu.SmartTest.Model;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Professor extends Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4827112727112617592L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "idProfessor", unique = true, nullable = false)
//	@JsonProperty("idProfessor")
//	private long idProfessor;

//	@Column(name="matricula")
//	@JsonProperty("matricula")
//	private int matricula;
//	
//	@Column(name="nome")
//	@JsonProperty("nome")
//	private String nome;
//	
//	@Column(name="sexo")
//	@JsonProperty("sexo")
//	private String sexo;
//	
//	@Column(name="senha")
//	@JsonProperty("senha")
//	private String senha;

	@ManyToMany(mappedBy = "professores")
	@JsonProperty("disciplinas")
	private List<Disciplina> disciplinas = new ArrayList<>();



	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}


	
}
