package br.edu.facear.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Tipo_Ligacao")
public class Tipo_Ligacao {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id_tipoligacao;
	private String nome;
	public Long getId_tipoligacao() {
		return id_tipoligacao;
	}
	public void setId_tipoligacao(Long id_tipoligacao) {
		this.id_tipoligacao = id_tipoligacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Tipo_Ligacao [id_tipoligacao=" + id_tipoligacao + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipoligacao == null) ? 0 : id_tipoligacao.hashCode());
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
		Tipo_Ligacao other = (Tipo_Ligacao) obj;
		if (id_tipoligacao == null) {
			if (other.id_tipoligacao != null)
				return false;
		} else if (!id_tipoligacao.equals(other.id_tipoligacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public Tipo_Ligacao(Long id_tipoligacao, String nome) {
		super();
		this.id_tipoligacao = id_tipoligacao;
		this.nome = nome;
	}
	public Tipo_Ligacao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@OneToMany
	//private List <Atividade_Ligacao> listaligacao;

		
}
