package br.com.gestorfinanceiro.repository.consultas;

import br.com.gestorfinanceiro.model.Usuario;
import br.com.gestorfinanceiro.repository.filter.UsuarioFilter;

public interface UsuarioRepositoryQuery {

	public Usuario findByEmailESenha(UsuarioFilter filter);
}
