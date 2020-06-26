package br.com.gestorfinanceiro.repository.consultas;

import java.util.List;

import br.com.gestorfinanceiro.model.ContaAReceber;
import br.com.gestorfinanceiro.repository.filter.ContaAReceberFilter;

public interface ContaAReceberRepositoryQuery  {

		public List<ContaAReceber> filtrar(ContaAReceberFilter filter);
		
}
