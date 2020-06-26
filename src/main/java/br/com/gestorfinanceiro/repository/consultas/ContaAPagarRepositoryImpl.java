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

import br.com.gestorfinanceiro.model.ContaAPagar;
import br.com.gestorfinanceiro.model.ContaAPagar_;
import br.com.gestorfinanceiro.repository.filter.ContaAPagarFilter;

public class ContaAPagarRepositoryImpl implements ContaAPagarRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ContaAPagar> filtrar(ContaAPagarFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ContaAPagar> criteria = builder.createQuery(ContaAPagar.class);
		Root<ContaAPagar> root = criteria.from(ContaAPagar.class);

		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<ContaAPagar> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ContaAPagarFilter filter, CriteriaBuilder builder, Root<ContaAPagar> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(filter.getTitulo())) {
			predicates.add(builder.like(root.get(ContaAPagar_.titulo), "%" + filter.getTitulo() + "%"));
		}

		if (filter.getCategoria() != null) {
			predicates.add(builder.equal(root.get(ContaAPagar_.categoria), filter.getCategoria()));
		}

		if (filter.getDataVencimentoDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get(ContaAPagar_.dataVencimento), filter.getDataVencimentoDe()));
		}

		if (filter.getDataVencimentoAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get(ContaAPagar_.dataVencimento), filter.getDataVencimentoAte()));
		}

		if (filter.getDataPagamentoDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get(ContaAPagar_.dataPagamento), filter.getDataPagamentoDe()));
		}

		if (filter.getDataPagamentoAte() != null) {
			predicates
					.add(builder.lessThanOrEqualTo(root.get(ContaAPagar_.dataPagamento), filter.getDataPagamentoAte()));
		}

		if (filter.isIndPago()) {
			predicates.add(builder.equal(root.get(ContaAPagar_.indPago), filter.isIndPago()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
