package br.com.edu.SmartTest.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPessoa", unique = true, nullable = false)
	@JsonProperty("idPessoa")
	private long idPessoa;
	
	@Column(name = "nome")
	@JsonProperty("nome")
	private String nome;

	@Column(name = "sexo")
	@JsonProperty("sexo")
	private String sexo;
	
	
	@Column(name = "email")
	@JsonProperty("email")
	private String email;
	
	@OneToOne
	@JsonProperty("usuario")
	private Usuario usuario;
	
	@OneToMany
	List<Telefone> telefones =  new ArrayList<>();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	} 
}
