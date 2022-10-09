package br.edu.facear.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Negocio")
public class Negocio {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_negocio;
	private Date data;
	
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private Contato contato;

	public Long getId_negocio() {
		return id_negocio;
	}

	public void setId_negocio(Long id_negocio) {
		this.id_negocio = id_negocio;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Negocio [id_negocio=" + id_negocio + ", data=" + data + ", empresa=" + empresa + ", contato=" + contato
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id_negocio == null) ? 0 : id_negocio.hashCode());
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
		Negocio other = (Negocio) obj;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id_negocio == null) {
			if (other.id_negocio != null)
				return false;
		} else if (!id_negocio.equals(other.id_negocio))
			return false;
		return true;
	}

	public Negocio(Long id_negocio, Date data, Empresa empresa, Contato contato) {
		super();
		this.id_negocio = id_negocio;
		this.data = data;
		this.empresa = empresa;
		this.contato = contato;
	}

	public Negocio() {
		super();
		empresa = new Empresa();
		contato = new Contato();
	}

		
}
