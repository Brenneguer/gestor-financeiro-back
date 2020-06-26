package br.com.gestorfinanceiro.repository.filter;

import br.com.gestorfinanceiro.model.Tipo;
import br.com.gestorfinanceiro.model.Usuario;

public class CategoriaFilter {

	private Long codigo;
	private String nome;
	private Usuario usuario;
	private Tipo tipo;
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
	
	
	
}
