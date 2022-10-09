package br.edu.facear.dao;


import br.edu.facear.entity.Empresa;

public class FactoryDao {
	public static InterfaceDAO<Empresa> getEmpresaDao() {
		return new EmpresaDAO();
	}

}
