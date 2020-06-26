package br.com.gestorfinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gestorfinanceiro.model.ContaAPagar;
import br.com.gestorfinanceiro.repository.consultas.ContaAPagarRepositoryQuery;

public interface ContaAPagarRepository extends JpaRepository<ContaAPagar, Long>, ContaAPagarRepositoryQuery {

	@Query(value = "SELECT * FROM conta_a_pagar cap WHERE cap.titulo like '%:titulo%'", nativeQuery = true)
	public List<ContaAPagar> findByTitulo(@Param("titulo") String titulo);
	
}
