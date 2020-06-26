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

import br.com.gestorfinanceiro.model.ContaAReceber;
import br.com.gestorfinanceiro.model.ContaAReceber_;
import br.com.gestorfinanceiro.repository.filter.ContaAReceberFilter;

public class ContaAReceberRepositoryImpl implements ContaAReceberRepositoryQuery {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ContaAReceber> filtrar(ContaAReceberFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ContaAReceber> criteria = builder.createQuery(ContaAReceber.class);
		Root<ContaAReceber> root = criteria.from(ContaAReceber.class);

		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<ContaAReceber> query = manager.createQuery(criteria);

		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ContaAReceberFilter filter, CriteriaBuilder builder, Root<ContaAReceber> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (!StringUtils.isEmpty(filter.getTitulo())) {
			predicates.add(builder.like(root.get(ContaAReceber_.titulo), "%" + filter.getTitulo() + "%"));
		}

		if (filter.getDataRecebimentoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(ContaAReceber_.dataRecebimento),
					filter.getDataRecebimentoDe()));
		}

		if (filter.getDataRecebimentoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(ContaAReceber_.dataRecebimento),
					filter.getDataRecebimentoAte()));
		}

		if (filter.isIndRecebido()) {
			predicates.add(builder.equal(root.get(ContaAReceber_.indRecebido), filter.isIndRecebido()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
