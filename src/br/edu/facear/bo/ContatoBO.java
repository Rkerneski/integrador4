package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.ContatoDAO;
import br.edu.facear.dao.EmpresaDAO;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;

public class ContatoBO {
	public void salvar(Contato c) throws Exception{
		if((c.getNome()==null)||(c.getCpf()==null)||
				(c.getEndereco()==null)||(c.getCidade()==null)||(c.getResponsavel()==null)||(c.getTipocontato()==null)/*||(c.getOrigemcontato()==null)*/){
			throw new Exception("Dados");
		}
		
			ContatoDAO cdao = new ContatoDAO();
			cdao.salvar(c);
			
	}
	
	public Collection<Contato> listar() {
		ContatoDAO emdao = new ContatoDAO();
		return emdao.listar();
	}

	public void editar(Contato c)throws Exception {
		if((c.getNome()==null)||(c.getCpf()==null)||
				(c.getEndereco()==null)||(c.getCidade()==null)||(c.getResponsavel()==null)||(c.getTipocontato()==null)/*||(c.getOrigemcontato()==null)*/){
			throw new Exception("Dados");
		}
		
			ContatoDAO cdao = new ContatoDAO();
			cdao.editar(c);
	}
	
}
