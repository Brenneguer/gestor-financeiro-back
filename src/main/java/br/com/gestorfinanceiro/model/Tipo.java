package br.com.gestorfinanceiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Weuller Brenneguer
 *
 */
@Entity
@Table(name = "tipo")
public final class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long codigo;
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
}
