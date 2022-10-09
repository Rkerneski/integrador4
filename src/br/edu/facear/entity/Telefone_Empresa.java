package br.edu.facear.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.engine.Cascade;

@Entity
@Table (name = "Telefone_Empresa")
public class Telefone_Empresa {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_telefonee;
	private String numero;
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
	private Empresa empresa;
	
	@ManyToOne
	private Tipo_Telefone tipotelefone;

		public Long getId_telefonee() {
		return id_telefonee;
	}

	public void setId_telefonee(Long id_telefonee) {
		this.id_telefonee = id_telefonee;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Tipo_Telefone getTipotelefone() {
		return tipotelefone;
	}

	public void setTipotelefone(Tipo_Telefone tipotelefone) {
		this.tipotelefone = tipotelefone;
	}

		@Override
	public String toString() {
		return "Telefone_Empresa [id_telefonee=" + id_telefonee + ", numero=" + numero + ", empresa=" + empresa
				+ ", tipotelefone=" + tipotelefone + "]";
	}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
			result = prime * result + ((id_telefonee == null) ? 0 : id_telefonee.hashCode());
			result = prime * result + ((numero == null) ? 0 : numero.hashCode());
			result = prime * result + ((tipotelefone == null) ? 0 : tipotelefone.hashCode());
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
			Telefone_Empresa other = (Telefone_Empresa) obj;
			if (empresa == null) {
				if (other.empresa != null)
					return false;
			} else if (!empresa.equals(other.empresa))
				return false;
			if (id_telefonee == null) {
				if (other.id_telefonee != null)
					return false;
			} else if (!id_telefonee.equals(other.id_telefonee))
				return false;
			if (numero == null) {
				if (other.numero != null)
					return false;
			} else if (!numero.equals(other.numero))
				return false;
			if (tipotelefone == null) {
				if (other.tipotelefone != null)
					return false;
			} else if (!tipotelefone.equals(other.tipotelefone))
				return false;
			return true;
		}
		
		public Telefone_Empresa(Long id_telefonee, String numero, Empresa empresa, Tipo_Telefone tipotelefone) {
			super();
			this.id_telefonee = id_telefonee;
			this.numero = numero;
			this.empresa = empresa;
			this.tipotelefone = tipotelefone;
		}

		public Telefone_Empresa() {
		super();
		tipotelefone = new Tipo_Telefone();
		empresa = new Empresa();
	}
}
