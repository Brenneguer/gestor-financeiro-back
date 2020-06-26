package br.com.gestorfinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gestorfinanceiro.model.ContaAReceber;
import br.com.gestorfinanceiro.repository.consultas.ContaAReceberRepositoryQuery;

public interface ContaAReceberRepository extends JpaRepository<ContaAReceber, Long>, ContaAReceberRepositoryQuery {

	@Query(value = "SELECT * FROM conta_a_receber car WHERE car.titulo like %:salario%", nativeQuery = true)
	public List<ContaAReceber> findByTitulo(@Param("salario") String titulo);
}
