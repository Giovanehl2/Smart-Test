package br.com.edu.SmartTest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Telefones")
public class Telefone {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTelefone", unique = true, nullable = false)
	@JsonProperty("idTelefone")
	private long idTelefone;

	@Column(name = "ddd")
	@JsonProperty("ddd")
	private Integer ddd;
	
	@Column(name = "telefone")
	@JsonProperty("telefone")
	private Long telefone;
	
}
