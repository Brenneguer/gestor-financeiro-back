package br.com.gestorfinanceiro.repository.consultas;

import java.util.List;

import br.com.gestorfinanceiro.model.Categoria;

public interface CategoriaRepositoryQuery {
	
	public List<Categoria> listar();
	
	public List<Categoria> filtrarTipo(String tipo);
}
