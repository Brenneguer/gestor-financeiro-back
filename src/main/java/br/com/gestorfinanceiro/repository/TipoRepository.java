package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

	public Tipo findByTipo(String tipo);
	
	
}
