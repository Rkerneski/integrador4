package br.edu.facear.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Telefone_Contato")
public class Telefone_Contato {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_telefonec;
	private String numero;
	
	@ManyToOne
	private Tipo_Telefone tipotelefone;
	
	@ManyToOne
	private Contato contato;

	public Long getId_telefonec() {
		return id_telefonec;
	}

	public void setId_telefonec(Long id_telefonec) {
		this.id_telefonec = id_telefonec;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Tipo_Telefone getTipotelefone() {
		return tipotelefone;
	}

	public void setTipotelefone(Tipo_Telefone tipotelefone) {
		this.tipotelefone = tipotelefone;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Telefone_Contato [id_telefonec=" + id_telefonec + ", numero=" + numero + ", tipotelefone="
				+ tipotelefone + ", contato=" + contato + "]";
	}

	public Telefone_Contato(Long id_telefonec, String numero, Tipo_Telefone tipotelefone, Contato contato) {
		super();
		this.id_telefonec = id_telefonec;
		this.numero = numero;
		this.tipotelefone = tipotelefone;
		this.contato = contato;
	}

	public Telefone_Contato() {
		super();
		tipotelefone = new Tipo_Telefone();
		contato = new Contato();
	}

	
}
