package br.com.gestorfinanceiro.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContaAReceber.class)
public abstract class ContaAReceber_ {

	public static volatile SingularAttribute<ContaAReceber, Long> codigo;
	public static volatile SingularAttribute<ContaAReceber, Categoria> categoria;
	public static volatile SingularAttribute<ContaAReceber, Double> valor;
	public static volatile SingularAttribute<ContaAReceber, String> titulo;
	public static volatile SingularAttribute<ContaAReceber, Usuario> usuario;
	public static volatile SingularAttribute<ContaAReceber, Boolean> indRecebido;
	public static volatile SingularAttribute<ContaAReceber, Boolean> indDeletado;
	public static volatile SingularAttribute<ContaAReceber, LocalDate> dataRecebimento;

}

