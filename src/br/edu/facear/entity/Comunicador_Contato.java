package br.edu.facear.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Comunicador_Contato")
public class Comunicador_Contato {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_comunicadorc;
	private String nome;
	
	@ManyToOne
	private Contato contato;
	
	@ManyToOne
	private Tipo_Comunicador tipocomunicador;

	public Long getId_comunicadorc() {
		return id_comunicadorc;
	}

	public void setId_comunicadorc(Long id_comunicadorc) {
		this.id_comunicadorc = id_comunicadorc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
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
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((id_comunicadorc == null) ? 0 : id_comunicadorc.hashCode());
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
		Comunicador_Contato other = (Comunicador_Contato) obj;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (id_comunicadorc == null) {
			if (other.id_comunicadorc != null)
				return false;
		} else if (!id_comunicadorc.equals(other.id_comunicadorc))
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
		return "Comunicador_Contato [id_comunicadorc=" + id_comunicadorc + ", nome=" + nome + ", contato=" + contato
				+ ", tipocomunicador=" + tipocomunicador + "]";
	}

	public Comunicador_Contato(Long id_comunicadorc, String nome, Contato contato, Tipo_Comunicador tipocomunicador) {
		super();
		this.id_comunicadorc = id_comunicadorc;
		this.nome = nome;
		this.contato = contato;
		this.tipocomunicador = tipocomunicador;
	}

	public Comunicador_Contato() {
		super();
		tipocomunicador = new Tipo_Comunicador();
		contato = new Contato();
	}
}
