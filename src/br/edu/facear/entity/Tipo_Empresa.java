package br.edu.facear.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Tipo_Empresa")
public class Tipo_Empresa {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_tipoEmpresa;
	private String nome;
	public Long getId_tipoEmpresa() {
		return id_tipoEmpresa;
	}
	public void setId_tipoEmpresa(Long id_tipoEmpresa) {
		this.id_tipoEmpresa = id_tipoEmpresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Tipo_Empresa [id_tipoEmpresa=" + id_tipoEmpresa + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipoEmpresa == null) ? 0 : id_tipoEmpresa.hashCode());
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
		Tipo_Empresa other = (Tipo_Empresa) obj;
		if (id_tipoEmpresa == null) {
			if (other.id_tipoEmpresa != null)
				return false;
		} else if (!id_tipoEmpresa.equals(other.id_tipoEmpresa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public Tipo_Empresa(Long id_tipoEmpresa, String nome) {
		super();
		this.id_tipoEmpresa = id_tipoEmpresa;
		this.nome = nome;
	}
	public Tipo_Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@OneToMany
	//private List <Empresa> listaempresa;

		
}
