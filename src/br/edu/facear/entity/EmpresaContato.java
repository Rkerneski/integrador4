package br.edu.facear.entity;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "EmpresaContato")
public class EmpresaContato {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_empresacontato;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private Contato contato;

	public Long getId_empresacontato() {
		return id_empresacontato;
	}

	public void setId_empresacontato(Long id_empresacontato) {
		this.id_empresacontato = id_empresacontato;
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
		return "EmpresaContato [id_empresacontato=" + id_empresacontato + ", empresa=" + empresa + ", contato="
				+ contato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id_empresacontato == null) ? 0 : id_empresacontato.hashCode());
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
		EmpresaContato other = (EmpresaContato) obj;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id_empresacontato == null) {
			if (other.id_empresacontato != null)
				return false;
		} else if (!id_empresacontato.equals(other.id_empresacontato))
			return false;
		return true;
	}

	public EmpresaContato(Long id_empresacontato, Empresa empresa, Contato contato) {
		super();
		this.id_empresacontato = id_empresacontato;
		this.empresa = empresa;
		this.contato = contato;
	}

	public EmpresaContato() {
		super();
		empresa = new Empresa();
		contato = new Contato();
	}
	
	

}
