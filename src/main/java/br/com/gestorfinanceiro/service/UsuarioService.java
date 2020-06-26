package br.com.gestorfinanceiro.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.model.Usuario;
import br.com.gestorfinanceiro.repository.UsuarioRepository;
import br.com.gestorfinanceiro.repository.filter.UsuarioFilter;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario atualizar(Usuario usuario) {
		Usuario usuarioSalvo = usuarioRepository.findById(usuario.getCodigo()).get();
		if (usuarioSalvo == null) {
			throw new NoSuchElementException();
		}
		return usuarioRepository.save(usuario);
	}

	public boolean deletar(Usuario usuario) {
		if (usuario.getCodigo() != null) {
			usuario.setIndDeletado(true);
			usuarioRepository.save(usuario);
			return true;
		} else
			return false;
	}
	
	public Usuario login(UsuarioFilter usuario) {
		return usuarioRepository.findByEmailESenha(usuario);
	}
}
