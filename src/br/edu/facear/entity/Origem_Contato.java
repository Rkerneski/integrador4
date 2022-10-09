package br.edu.facear.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Origem_Contato")
public class Origem_Contato {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_origemcontato;
	private String nome;
	public Long getId_origemcontato() {
		return id_origemcontato;
	}
	public void setId_origemcontato(Long id_origemcontato) {
		this.id_origemcontato = id_origemcontato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Origem_Contato [id_origemcontato=" + id_origemcontato + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_origemcontato == null) ? 0 : id_origemcontato.hashCode());
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
		Origem_Contato other = (Origem_Contato) obj;
		if (id_origemcontato == null) {
			if (other.id_origemcontato != null)
				return false;
		} else if (!id_origemcontato.equals(other.id_origemcontato))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public Origem_Contato(Long id_origemcontato, String nome) {
		super();
		this.id_origemcontato = id_origemcontato;
		this.nome = nome;
	}
	public Origem_Contato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@OneToMany
	//private List <Contato> listacontato;

}
