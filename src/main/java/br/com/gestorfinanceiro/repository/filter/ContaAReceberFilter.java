package br.com.gestorfinanceiro.repository.filter;

import java.time.LocalDate;

public class ContaAReceberFilter {

	private String titulo;
	private LocalDate dataRecebimentoDe;
	private LocalDate dataRecebimentoAte;
	private boolean indRecebido;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataRecebimentoDe() {
		return dataRecebimentoDe;
	}

	public void setDataRecebimentoDe(LocalDate dataRecebimentoDe) {
		this.dataRecebimentoDe = dataRecebimentoDe;
	}

	public LocalDate getDataRecebimentoAte() {
		return dataRecebimentoAte;
	}

	public void setDataRecebimentoAte(LocalDate dataRecebimentoAte) {
		this.dataRecebimentoAte = dataRecebimentoAte;
	}


	public boolean isIndRecebido() {
		return indRecebido;
	}

	public void setIndRecebido(boolean indRecebido) {
		this.indRecebido = indRecebido;
	}

	@Override
	public String toString() {
		return "[ Titulo: " + this.titulo + ", Data Recebimento entre: " + this.dataRecebimentoDe + " e " + this.dataRecebimentoAte + " ]";
	}
}
