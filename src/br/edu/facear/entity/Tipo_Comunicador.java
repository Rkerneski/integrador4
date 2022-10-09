package br.edu.facear.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Tipo_Comunicador")

public class Tipo_Comunicador {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_tipocomunicador;
	private String nome;
	public Long getId_tipocomunicador() {
		return id_tipocomunicador;
	}
	public void setId_tipocomunicador(Long id_tipocomunicador) {
		this.id_tipocomunicador = id_tipocomunicador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Tipo_Comunicador [id_tipocomunicador=" + id_tipocomunicador + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipocomunicador == null) ? 0 : id_tipocomunicador.hashCode());
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
		Tipo_Comunicador other = (Tipo_Comunicador) obj;
		if (id_tipocomunicador == null) {
			if (other.id_tipocomunicador != null)
				return false;
		} else if (!id_tipocomunicador.equals(other.id_tipocomunicador))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public Tipo_Comunicador(Long id_tipocomunicador, String nome) {
		super();
		this.id_tipocomunicador = id_tipocomunicador;
		this.nome = nome;
	}
	public Tipo_Comunicador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@OneToMany
	//private List <Comunicador_Contato> listacontatoc;
	
	//@OneToMany
	//private List <Comunicador_Empresa> listacontatoe;

	
}
