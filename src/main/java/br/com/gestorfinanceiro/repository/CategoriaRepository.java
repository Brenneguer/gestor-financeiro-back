package br.com.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestorfinanceiro.model.Categoria;
import br.com.gestorfinanceiro.repository.consultas.CategoriaRepositoryQuery;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>, CategoriaRepositoryQuery {

}