package br.com.gestorfinanceiro.repository.filter;

public class UsuarioFilter {

	private String email;
	private String senha;
	private Long codigo;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "[codigo: " + this.codigo +  "email: " + this.email + ", senha: " + this.senha +" ]";
	}
	
}
