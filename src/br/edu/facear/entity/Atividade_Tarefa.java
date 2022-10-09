package br.edu.facear.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name= "Atividade_Tarefa")
public class Atividade_Tarefa {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_tarefa;
	private Date data;
	private String observacao;
	private String duracao;
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToOne
	private Contato contato;
	
	@ManyToOne
	private Situacao situacao;

	
	public Long getId_tarefa() {
		return id_tarefa;
	}


	public void setId_tarefa(Long id_tarefa) {
		this.id_tarefa = id_tarefa;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public String getDuracao() {
		return duracao;
	}


	public void setDuracao(String duracao) {
		this.duracao = duracao;
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


	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	
	@Override
	public String toString() {
		return "Atividade_Tarefa [id_tarefa=" + id_tarefa + ", data=" + data + ", observacao=" + observacao
				+ ", duracao=" + duracao + ", empresa=" + empresa + ", contato=" + contato + ", situacao=" + situacao
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id_tarefa == null) ? 0 : id_tarefa.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
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
		Atividade_Tarefa other = (Atividade_Tarefa) obj;
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
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id_tarefa == null) {
			if (other.id_tarefa != null)
				return false;
		} else if (!id_tarefa.equals(other.id_tarefa))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}


	public Atividade_Tarefa(Long id_tarefa, Date data, String observacao, String duracao, Empresa empresa,
			Contato contato, Situacao situacao) {
		super();
		this.id_tarefa = id_tarefa;
		this.data = data;
		this.observacao = observacao;
		this.duracao = duracao;
		this.empresa = empresa;
		this.contato = contato;
		this.situacao = situacao;
	}


	public Atividade_Tarefa() {
		super();
		empresa = new Empresa();
		contato = new Contato();
		situacao = new Situacao();
	}
	
	

}
