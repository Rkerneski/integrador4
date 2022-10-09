package br.edu.facear.entity;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Atividade_Ligacao")
public class Atividade_Ligacao {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_ligacao;
	private Date data;
	private String assunto;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private Contato contato;
	
	@ManyToOne
	private Tipo_Ligacao tipoligacao;

	
	public Long getId_ligacao() {
		return id_ligacao;
	}


	public void setId_ligacao(Long id_ligacao) {
		this.id_ligacao = id_ligacao;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getAssunto() {
		return assunto;
	}


	public void setAssunto(String assunto) {
		this.assunto = assunto;
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


	public Tipo_Ligacao getTipoligacao() {
		return tipoligacao;
	}


	public void setTipoligacao(Tipo_Ligacao tipoligacao) {
		this.tipoligacao = tipoligacao;
	}

	
	@Override
	public String toString() {
		return "Atividade_Ligacao [id_ligacao=" + id_ligacao + ", data=" + data + ", assunto=" + assunto + ", empresa="
				+ empresa + ", contato=" + contato + ", tipoligacao=" + tipoligacao + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id_ligacao == null) ? 0 : id_ligacao.hashCode());
		result = prime * result + ((tipoligacao == null) ? 0 : tipoligacao.hashCode());
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
		Atividade_Ligacao other = (Atividade_Ligacao) obj;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
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
		if (id_ligacao == null) {
			if (other.id_ligacao != null)
				return false;
		} else if (!id_ligacao.equals(other.id_ligacao))
			return false;
		if (tipoligacao == null) {
			if (other.tipoligacao != null)
				return false;
		} else if (!tipoligacao.equals(other.tipoligacao))
			return false;
		return true;
	}

	
	public Atividade_Ligacao(Long id_ligacao, Date data, String assunto, Empresa empresa, Contato contato,
			Tipo_Ligacao tipoligacao) {
		super();
		this.id_ligacao = id_ligacao;
		this.data = data;
		this.assunto = assunto;
		this.empresa = empresa;
		this.contato = contato;
		this.tipoligacao = tipoligacao;
	}


	public Atividade_Ligacao() {
		super();
		empresa = new Empresa();
		contato = new Contato();
		tipoligacao = new Tipo_Ligacao();
	}
	

}
