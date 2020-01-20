package br.com.edu.SmartTest.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Respostas")
public class Resposta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8986474690975724809L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idResposta", unique = true, nullable = false)
	@JsonProperty("")
	private long idResposta;

	@Column(name="resposta")
	@JsonProperty("")
	private String resposta;
		
	@ManyToOne
	@JoinColumn(name = "idPergunta")
	@JsonProperty("")
	private Pergunta pergunta;

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

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

}
