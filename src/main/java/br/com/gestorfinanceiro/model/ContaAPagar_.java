package br.com.gestorfinanceiro.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContaAPagar.class)
public abstract class ContaAPagar_ {

	public static volatile SingularAttribute<ContaAPagar, Long> codigo;
	public static volatile SingularAttribute<ContaAPagar, Boolean> indPago;
	public static volatile SingularAttribute<ContaAPagar, LocalDate> dataPagamento;
	public static volatile SingularAttribute<ContaAPagar, Categoria> categoria;
	public static volatile SingularAttribute<ContaAPagar, LocalDate> dataVencimento;
	public static volatile SingularAttribute<ContaAPagar, Double> valor;
	public static volatile SingularAttribute<ContaAPagar, String> titulo;
	public static volatile SingularAttribute<ContaAPagar, Usuario> usuario;
	public static volatile SingularAttribute<ContaAPagar, Boolean> indDeletado;

}

