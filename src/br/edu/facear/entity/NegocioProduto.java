package br.edu.facear.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "NegocioProduto")
public class NegocioProduto {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_negocioproduto;
	
	@ManyToOne
	private Negocio negocio;
	
	@ManyToOne
	private Produto produto;

	public Long getId_negocioproduto() {
		return id_negocioproduto;
	}

	public void setId_negocioproduto(Long id_negocioproduto) {
		this.id_negocioproduto = id_negocioproduto;
	}

	public Negocio getNegocio() {
		return negocio;
	}

	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "NegocioProduto [id_negocioproduto=" + id_negocioproduto + ", negocio=" + negocio + ", produto="
				+ produto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_negocioproduto == null) ? 0 : id_negocioproduto.hashCode());
		result = prime * result + ((negocio == null) ? 0 : negocio.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		NegocioProduto other = (NegocioProduto) obj;
		if (id_negocioproduto == null) {
			if (other.id_negocioproduto != null)
				return false;
		} else if (!id_negocioproduto.equals(other.id_negocioproduto))
			return false;
		if (negocio == null) {
			if (other.negocio != null)
				return false;
		} else if (!negocio.equals(other.negocio))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	public NegocioProduto(Long id_negocioproduto, Negocio negocio, Produto produto) {
		super();
		this.id_negocioproduto = id_negocioproduto;
		this.negocio = negocio;
		this.produto = produto;
	}

	public NegocioProduto() {
		super();
		negocio = new Negocio();
		produto = new Produto();
	}
	
	

}
