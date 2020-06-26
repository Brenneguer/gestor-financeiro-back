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
@Table(name = "conta_a_pagar")
public class ContaAPagar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long codigo;
	private String titulo;
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private Double valor;
	private boolean indPago;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public boolean isIndPago() {
		return indPago;
	}

	public void setIndPago(boolean indPago) {
		this.indPago = indPago;
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
		ContaAPagar other = (ContaAPagar) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
