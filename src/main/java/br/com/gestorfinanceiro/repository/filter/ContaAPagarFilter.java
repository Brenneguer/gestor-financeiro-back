package br.com.gestorfinanceiro.repository.filter;

import java.time.LocalDate;

import br.com.gestorfinanceiro.model.Categoria;

public class ContaAPagarFilter {

	private String titulo;
	private LocalDate dataVencimentoDe;
	private LocalDate dataVencimentoAte;
	private LocalDate dataPagamentoDe;
	private LocalDate dataPagamentoAte;
	private Categoria categoria;
	private boolean indPago;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataVencimentoDe() {
		return dataVencimentoDe;
	}

	public void setDataVencimentoDe(LocalDate dataVencimentoDe) {
		this.dataVencimentoDe = dataVencimentoDe;
	}

	public LocalDate getDataVencimentoAte() {
		return dataVencimentoAte;
	}

	public void setDataVencimentoAte(LocalDate dataVencimentoAte) {
		this.dataVencimentoAte = dataVencimentoAte;
	}

	public LocalDate getDataPagamentoDe() {
		return dataPagamentoDe;
	}

	public void setDataPagamentoDe(LocalDate dataPagamentoDe) {
		this.dataPagamentoDe = dataPagamentoDe;
	}

	public LocalDate getDataPagamentoAte() {
		return dataPagamentoAte;
	}

	public void setDataPagamentoAte(LocalDate dataPagamentoAte) {
		this.dataPagamentoAte = dataPagamentoAte;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isIndPago() {
		return indPago;
	}

	public void setIndPago(boolean indPago) {
		this.indPago = indPago;
	}

	@Override
	public String toString() {
		return "[ Titulo: " + this.titulo + ", data vencimento: " + this.dataVencimentoDe + " e "
				+ this.dataVencimentoAte + ", data de pagamento: " + this.dataPagamentoDe + " e "
				+ this.dataPagamentoAte + " ]";
	}

}
