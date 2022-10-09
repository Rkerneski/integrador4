package br.edu.facear.entity;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table (name = "Empresa")
public class Empresa {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_empresa;
	private String nome;
	private String cnpj;
	private String responsavel;
	private String endereco;
	private String numero;
	private String cidade;
	private String foto;
	
	@ManyToOne //(cascade=CascadeType.PERSIST)  
	private  Tipo_Empresa tipoempresa;
	
	
	
	//@ManyToMany //(mappedBy="listaempresa")
    //@JoinTable(name = "EmpresaContato", joinColumns = @JoinColumn(name = "id_empresa"), inverseJoinColumns = @JoinColumn(name = "id_contato"))
	//private List <Contato> listacontato;
		
		
		public Long getId_empresa() {
			return id_empresa;
		}



		public void setId_empresa(Long id_empresa) {
			this.id_empresa = id_empresa;
		}



		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public String getCnpj() {
			return cnpj;
		}



		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
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



		public String getNumero() {
			return numero;
		}



		public void setNumero(String numero) {
			this.numero = numero;
		}



		public String getCidade() {
			return cidade;
		}



		public void setCidade(String cidade) {
			this.cidade = cidade;
		}



		public String getFoto() {
			return foto;
		}



		public void setFoto(String foto) {
			this.foto = foto;
		}



		public Tipo_Empresa getTipoempresa() {
			return tipoempresa;
		}



		public void setTipoempresa(Tipo_Empresa tipoempresa) {
			this.tipoempresa = tipoempresa;
		}



		@Override
		public String toString() {
			return "Empresa [id_empresa=" + id_empresa + ", nome=" + nome + ", cnpj=" + cnpj + ", responsavel="
					+ responsavel + ", endereco=" + endereco + ", numero=" + numero + ", cidade=" + cidade + ", foto="
					+ foto + ", tipoempresa=" + tipoempresa + "]";
		}



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
			result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
			result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
			result = prime * result + ((foto == null) ? 0 : foto.hashCode());
			result = prime * result + ((id_empresa == null) ? 0 : id_empresa.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			result = prime * result + ((numero == null) ? 0 : numero.hashCode());
			result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
			result = prime * result + ((tipoempresa == null) ? 0 : tipoempresa.hashCode());
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
			Empresa other = (Empresa) obj;
			if (cidade == null) {
				if (other.cidade != null)
					return false;
			} else if (!cidade.equals(other.cidade))
				return false;
			if (cnpj == null) {
				if (other.cnpj != null)
					return false;
			} else if (!cnpj.equals(other.cnpj))
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
			if (id_empresa == null) {
				if (other.id_empresa != null)
					return false;
			} else if (!id_empresa.equals(other.id_empresa))
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
			if (responsavel == null) {
				if (other.responsavel != null)
					return false;
			} else if (!responsavel.equals(other.responsavel))
				return false;
			if (tipoempresa == null) {
				if (other.tipoempresa != null)
					return false;
			} else if (!tipoempresa.equals(other.tipoempresa))
				return false;
			return true;
		}



		public Empresa(Long id_empresa, String nome, String cnpj, String responsavel, String endereco, String numero,
				String cidade, String foto, Tipo_Empresa tipoempresa) {
			super();
			this.id_empresa = id_empresa;
			this.nome = nome;
			this.cnpj = cnpj;
			this.responsavel = responsavel;
			this.endereco = endereco;
			this.numero = numero;
			this.cidade = cidade;
			this.foto = foto;
			this.tipoempresa = tipoempresa;
		}
	
		public Empresa() {
			super();
			
				tipoempresa = new Tipo_Empresa();
			
			// TODO Auto-generated constructor stub
		}
		
}
