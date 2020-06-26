package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Usuario;
import br.com.gestorfinanceiro.repository.consultas.UsuarioRepositoryQuery;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery{
	
}
