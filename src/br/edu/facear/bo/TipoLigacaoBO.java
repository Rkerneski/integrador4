package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.TipoLigacaoDAO;
import br.edu.facear.entity.Tipo_Ligacao;

public class TipoLigacaoBO {
	public void salvar(Tipo_Ligacao l)throws Exception{
		if(l.getNome().equals(null)){
			throw new Exception("Cadastrar nome");
		}
		TipoLigacaoDAO dao = new TipoLigacaoDAO();
		dao.salvar(l);
	}
	public Collection<Tipo_Ligacao>listar(){
		TipoLigacaoDAO dao = new TipoLigacaoDAO();
		return dao.listar();
	}
}
