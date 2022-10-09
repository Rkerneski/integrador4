package br.edu.facear.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Tipo_Contato")
public class Tipo_Contato {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_tipocontato;
	private String nome;
	public Long getId_tipocontato() {
		return id_tipocontato;
	}
	public void setId_tipocontato(Long id_tipocontato) {
		this.id_tipocontato = id_tipocontato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Tipo_Contato [id_tipocontato=" + id_tipocontato + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipocontato == null) ? 0 : id_tipocontato.hashCode());
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
		Tipo_Contato other = (Tipo_Contato) obj;
		if (id_tipocontato == null) {
			if (other.id_tipocontato != null)
				return false;
		} else if (!id_tipocontato.equals(other.id_tipocontato))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public Tipo_Contato(Long id_tipocontato, String nome) {
		super();
		this.id_tipocontato = id_tipocontato;
		this.nome = nome;
	}
	public Tipo_Contato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@OneToMany
	//private List <Contato> listacontato;

	
}
