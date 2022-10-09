package br.edu.facear.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Situacao")
public class Situacao {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_situacao;
	private String nome;
	public Long getId_situacao() {
		return id_situacao;
	}
	public void setId_situacao(Long id_situacao) {
		this.id_situacao = id_situacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Situacao [id_situacao=" + id_situacao + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_situacao == null) ? 0 : id_situacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Situacao other = (Situacao) obj;
		if (id_situacao == null) {
			if (other.id_situacao != null)
				return false;
		} else if (!id_situacao.equals(other.id_situacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public Situacao(Long id_situacao, String nome) {
		super();
		this.id_situacao = id_situacao;
		this.nome = nome;
	}
	public Situacao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
