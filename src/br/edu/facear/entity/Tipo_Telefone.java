package br.edu.facear.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Tipo_Telefone")

public class Tipo_Telefone {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_tipotelefone;
	private String nome;
	public Long getId_tipotelefone() {
		return id_tipotelefone;
	}
	public void setId_tipotelefone(Long id_tipotelefone) {
		this.id_tipotelefone = id_tipotelefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Tipo_Telefone [id_tipotelefone=" + id_tipotelefone + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipotelefone == null) ? 0 : id_tipotelefone.hashCode());
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
		Tipo_Telefone other = (Tipo_Telefone) obj;
		if (id_tipotelefone == null) {
			if (other.id_tipotelefone != null)
				return false;
		} else if (!id_tipotelefone.equals(other.id_tipotelefone))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public Tipo_Telefone(Long id_tipotelefone, String nome) {
		super();
		this.id_tipotelefone = id_tipotelefone;
		this.nome = nome;
	}
	public Tipo_Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@OneToMany
	//private List <Telefone_Empresa> listatelefonee;
	
	//@OneToMany
	//private List <Telefone_Contato> listatelefonec;

	
}
