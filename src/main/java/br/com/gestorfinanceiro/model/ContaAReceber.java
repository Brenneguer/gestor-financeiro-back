package br.com.gestorfinanceiro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Weuller Brenneguer
 *
 */
@Entity
@Table(name = "conta_a_receber")
public class ContaAReceber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	private LocalDate dataRecebimento;
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	private boolean indRecebido;
	private boolean indDeletado;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public boolean isIndDeletado() {
		return indDeletado;
	}

	public void setIndDeletado(boolean indDeletado) {
		this.indDeletado = indDeletado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isIndRecebido() {
		return indRecebido;
	}

	public void setIndRecebido(boolean indRecebido) {
		this.indRecebido = indRecebido;
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
		ContaAReceber other = (ContaAReceber) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
