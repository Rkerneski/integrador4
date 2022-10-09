package br.edu.facear.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Comunicador_Empresa")
public class Comunicador_Empresa {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_comunicadore;
	private String nome;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private Tipo_Comunicador tipocomunicador;

	public Long getId_comunicadore() {
		return id_comunicadore;
	}

	public void setId_comunicadore(Long id_comunicadore) {
		this.id_comunicadore = id_comunicadore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Tipo_Comunicador getTipocomunicador() {
		return tipocomunicador;
	}

	public void setTipocomunicador(Tipo_Comunicador tipocomunicador) {
		this.tipocomunicador = tipocomunicador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id_comunicadore == null) ? 0 : id_comunicadore.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipocomunicador == null) ? 0 : tipocomunicador.hashCode());
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
		Comunicador_Empresa other = (Comunicador_Empresa) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id_comunicadore == null) {
			if (other.id_comunicadore != null)
				return false;
		} else if (!id_comunicadore.equals(other.id_comunicadore))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipocomunicador == null) {
			if (other.tipocomunicador != null)
				return false;
		} else if (!tipocomunicador.equals(other.tipocomunicador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comunicador_Empresa [id_comunicadore=" + id_comunicadore + ", nome=" + nome + ", empresa=" + empresa
				+ ", tipocomunicador=" + tipocomunicador + "]";
	}

	public Comunicador_Empresa(Long id_comunicadore, String nome, Empresa empresa, Tipo_Comunicador tipocomunicador) {
		super();
		this.id_comunicadore = id_comunicadore;
		this.nome = nome;
		this.empresa = empresa;
		this.tipocomunicador = tipocomunicador;
	}

	public Comunicador_Empresa() {
		super();
		empresa = new Empresa();
		tipocomunicador = new Tipo_Comunicador();
	}
	
}
