package br.com.gestorfinanceiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Weuller Brenneguer
 *
 */
@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@NotNull
	private String nome;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;
	
	private boolean indDeletado;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public boolean isIndDeletado() {
		return indDeletado;
	}

	public void setIndDeletado(boolean indDeletado) {
		this.indDeletado = indDeletado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


}
