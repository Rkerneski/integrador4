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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Contato")
public class Contato {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_contato;
	private String nome;
	private String cpf;
	private String responsavel;
	private String endereco;
	private String cidade;
	private Date aniversario;
	private String foto;
	private String numero;
	
	
	//@ManyToMany //(mappedBy="listacontato")
	 //@JoinTable(name = "EmpresaContato", joinColumns = @JoinColumn(name = "id_empresa"), inverseJoinColumns = @JoinColumn(name = "id_contato"))
	//private List <Empresa> listaempresa;
	
	
	@ManyToOne
	private Tipo_Contato tipocontato;
	
	@ManyToOne
	private Origem_Contato origemcontato;

	
	
	public Long getId_contato() {
		return id_contato;
	}



	public void setId_contato(Long id_contato) {
		this.id_contato = id_contato;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getResponsavel() {
		return responsavel;
	}



	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public Date getAniversario() {
		return aniversario;
	}



	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public Tipo_Contato getTipocontato() {
		return tipocontato;
	}



	public void setTipocontato(Tipo_Contato tipocontato) {
		this.tipocontato = tipocontato;
	}



	public Origem_Contato getOrigemcontato() {
		return origemcontato;
	}



	public void setOrigemcontato(Origem_Contato origemcontato) {
		this.origemcontato = origemcontato;
	}



	@Override
	public String toString() {
		return "Contato [id_contato=" + id_contato + ", nome=" + nome + ", cpf=" + cpf + ", responsavel=" + responsavel
				+ ", endereco=" + endereco + ", cidade=" + cidade + ", aniversario=" + aniversario + ", foto=" + foto
				+ ", numero=" + numero + ", tipocontato=" + tipocontato + ", origemcontato=" + origemcontato + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aniversario == null) ? 0 : aniversario.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((id_contato == null) ? 0 : id_contato.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((origemcontato == null) ? 0 : origemcontato.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result + ((tipocontato == null) ? 0 : tipocontato.hashCode());
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
		Contato other = (Contato) obj;
		if (aniversario == null) {
			if (other.aniversario != null)
				return false;
		} else if (!aniversario.equals(other.aniversario))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (id_contato == null) {
			if (other.id_contato != null)
				return false;
		} else if (!id_contato.equals(other.id_contato))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (origemcontato == null) {
			if (other.origemcontato != null)
				return false;
		} else if (!origemcontato.equals(other.origemcontato))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (tipocontato == null) {
			if (other.tipocontato != null)
				return false;
		} else if (!tipocontato.equals(other.tipocontato))
			return false;
		return true;
	}



	public Contato(Long id_contato, String nome, String cpf, String responsavel, String endereco, String cidade,
			Date aniversario, String foto, String numero, Tipo_Contato tipocontato, Origem_Contato origemcontato) {
		super();
		this.id_contato = id_contato;
		this.nome = nome;
		this.cpf = cpf;
		this.responsavel = responsavel;
		this.endereco = endereco;
		this.cidade = cidade;
		this.aniversario = aniversario;
		this.foto = foto;
		this.numero = numero;
		this.tipocontato = tipocontato;
		this.origemcontato = origemcontato;
	}



	public Contato() {
		super();
		tipocontato = new Tipo_Contato();
		origemcontato = new Origem_Contato();
		// TODO Auto-generated constructor stub
	}

				
}
