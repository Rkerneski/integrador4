package br.edu.facear.dao;

import java.util.List;

public interface InterfaceDAO <T> {
	public void salvar(T t);
	public List<T> listar();
	public void editar (T t);
	public T getObjectTById (Long id);
	public void excluir (T t);
}
