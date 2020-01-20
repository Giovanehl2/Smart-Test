package br.com.edu.SmartTest.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Provas")
public class Prova implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1380347614810639993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProva", unique = true, nullable = false)
	@JsonProperty("")
	private long idProva;

	@Column(name = "descricaoProva")
	@JsonProperty("")
	private String descricaoProva;

	@ManyToMany(mappedBy = "provas")
	@JsonProperty("")
	private List<Disciplina> disciplinas;

	@ManyToOne
	@JoinColumn(name = "idTurma")
	@JsonProperty("")
	private Turma turma;

	public String getDescricaoProva() {
		return descricaoProva;
	}

	public void setDescricaoProva(String descricaoProva) {
		this.descricaoProva = descricaoProva;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public long getIdProva() {
		return idProva;
	}

	public void setIdProva(long idProva) {
		this.idProva = idProva;
	}
}
