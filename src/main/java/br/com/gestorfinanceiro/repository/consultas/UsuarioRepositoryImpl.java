package br.com.gestorfinanceiro.repository.consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.gestorfinanceiro.model.Usuario;
import br.com.gestorfinanceiro.model.Usuario_;
import br.com.gestorfinanceiro.repository.filter.UsuarioFilter;

public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery {
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public Usuario findByEmailESenha(UsuarioFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> root = criteria.from(Usuario.class);
		
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<Usuario> query = manager.createQuery(criteria);
		return query.getSingleResult();
	}
	
	
	private Predicate[] criarRestricoes(UsuarioFilter filter, CriteriaBuilder builder, Root<Usuario> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(filter.getEmail())) {
			predicates.add(builder.equal(root.get(Usuario_.email), filter.getEmail()));
		}
		
		if (!StringUtils.isEmpty(filter.getSenha())) {
			predicates.add(builder.equal(root.get(Usuario_.senha), filter.getSenha()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
		
	}

	
}
