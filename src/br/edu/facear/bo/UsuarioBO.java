package br.edu.facear.bo;



import br.edu.facear.dao.UsuarioDAO;
import br.edu.facear.entity.Usuario;

public class UsuarioBO {
		public void salvar(Usuario u)throws Exception {
			if((u.getNome()==null)||(u.getSenha()==null)){
				throw new Exception("Campos nulos");
			}
			UsuarioDAO udao = new UsuarioDAO();
			udao.cadastrar(u);
		}
		
	}

