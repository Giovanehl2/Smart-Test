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
@Table(name="Perguntas")
public class Pergunta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 348773850303418868L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPergunta", unique = true, nullable = false)
	@JsonProperty("idPergunta")
	private long idPergunta;

	@Column(name="tipoPergunta")
	@JsonProperty("tipoPergunta")
	private int tipoPergunta;
	
	@Column(name="nivelDificuldade")
	@JsonProperty("nivelDificuldade")
	private int nivelDificuldade;
	
	@Column(name="enunciado")
	@JsonProperty("enunciado")
	private String enunciado;
	
	@Column(name="anexo")
	@JsonProperty("anexo")
	private String anexo;
	
	@Column(name="respostaAluno")
	@JsonProperty("respostaAluno")
	private String respostaAluno;
	
	@Column(name="obsProfessor")
	@JsonProperty("obsProfessor")
	private String obsProfessor;
	
	@Column(name="perguntasCol")
	@JsonProperty("perguntasCol")
	private String perguntasCol;
	
	@Column(name="tpCorrecao")
	@JsonProperty("tpCorrecao")
	private String tpCorrecao;
	
	@Column(name="metricaAvaliativa")
	@JsonProperty("metricaAvaliativa")
	private String metricaAvaliativa;
	
//	@Column(name="disciplinas_idDisciplina")
//	@JsonProperty("")
//	private long disciplinas_idDisciplina;
//	
	

	@ManyToMany(mappedBy = "perguntas")
	@JsonProperty("disciplinas")
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "idPergunta")
	@JsonProperty("respostas")
	private List<Resposta> respostas = new ArrayList<>();

	public long getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(long idPergunta) {
		this.idPergunta = idPergunta;
	}

	public int getTipoPergunta() {
		return tipoPergunta;
	}

	public void setTipoPergunta(int tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}

	public int getNivelDificuldade() {
		return nivelDificuldade;
	}

	public void setNivelDificuldade(int nivelDificuldade) {
		this.nivelDificuldade = nivelDificuldade;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getRespostaAluno() {
		return respostaAluno;
	}

	public void setRespostaAluno(String respostaAluno) {
		this.respostaAluno = respostaAluno;
	}

	public String getObsProfessor() {
		return obsProfessor;
	}

	public void setObsProfessor(String obsProfessor) {
		this.obsProfessor = obsProfessor;
	}

	public String getPerguntasCol() {
		return perguntasCol;
	}

	public void setPerguntasCol(String perguntasCol) {
		this.perguntasCol = perguntasCol;
	}

	public String getTpCorrecao() {
		return tpCorrecao;
	}

	public void setTpCorrecao(String tpCorrecao) {
		this.tpCorrecao = tpCorrecao;
	}

	public String getMetricaAvaliativa() {
		return metricaAvaliativa;
	}

	public void setMetricaAvaliativa(String metricaAvaliativa) {
		this.metricaAvaliativa = metricaAvaliativa;
	}

//	public long getDisciplinas_idDisciplina() {
//		return disciplinas_idDisciplina;
//	}
//
//	public void setDisciplinas_idDisciplina(long disciplinas_idDisciplina) {
//		this.disciplinas_idDisciplina = disciplinas_idDisciplina;
//	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
}
