package br.com.gestorfinanceiro.repository.consultas;

import java.util.List;

import br.com.gestorfinanceiro.model.ContaAPagar;
import br.com.gestorfinanceiro.repository.filter.ContaAPagarFilter;

public interface ContaAPagarRepositoryQuery {

	public List<ContaAPagar> filtrar(ContaAPagarFilter filter);
	
}
