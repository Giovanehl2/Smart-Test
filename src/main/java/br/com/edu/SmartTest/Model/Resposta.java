package br.com.edu.SmartTest.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Respostas")
public class Resposta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idResposta", unique = true, nullable = false)
	private long idResposta;

	@Column(name="resposta")
	private String resposta;
	
	@Column(name="pergunta_idPerguntas")
	private long pergunta_idPerguntas;
	
	@OneToMany
	private List<Pergunta> perguntas;

	public long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(long idResposta) {
		this.idResposta = idResposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public long getPergunta_idPerguntas() {
		return pergunta_idPerguntas;
	}

	public void setPergunta_idPerguntas(long pergunta_idPerguntas) {
		this.pergunta_idPerguntas = pergunta_idPerguntas;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
}
