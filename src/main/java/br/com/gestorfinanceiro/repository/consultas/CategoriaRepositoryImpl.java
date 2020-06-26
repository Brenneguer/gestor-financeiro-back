package br.com.gestorfinanceiro.repository.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gestorfinanceiro.model.Categoria;
import br.com.gestorfinanceiro.model.Categoria_;
import br.com.gestorfinanceiro.repository.TipoRepository;

public class CategoriaRepositoryImpl implements CategoriaRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	public List<Categoria> listar() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		Root<Categoria> root = criteria.from(Categoria.class);
		
		criteria.where(builder.equal(root.get(Categoria_.indDeletado), false));
		criteria.orderBy(builder.desc(root.get(Categoria_.tipo)));
		TypedQuery<Categoria> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Categoria> filtrarTipo(String tipo) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
		Root<Categoria> root = criteria.from(Categoria.class);
		
		criteria.where(builder.equal(root.get(Categoria_.tipo), tipoRepository.findByTipo(tipo)));
		TypedQuery<Categoria> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}

}
