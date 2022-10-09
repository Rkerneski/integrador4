package br.edu.facear.TestBO;

import br.edu.facear.bo.TipoLigacaoBO;
import br.edu.facear.entity.Tipo_Ligacao;

public class TipoLigacaoTesteBo {
	public static void main(String[] args) {
		testeInsert();
	}
	public static void testeInsert(){
		Tipo_Ligacao liga = new Tipo_Ligacao();
		liga.setNome("Entrada");
		
		
		TipoLigacaoBO bo = new TipoLigacaoBO();
		
		try{
			bo.salvar(liga);
			System.out.println("salvo com sucesso!");
		}catch(Exception a){
			System.err.println("Erro ao inserir -> "+a.getMessage());
		}
	}

}
