package br.com.gestorfinanceiro.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorfinanceiro.event.RecursoCriadoEvent;
import br.com.gestorfinanceiro.model.Usuario;
import br.com.gestorfinanceiro.repository.UsuarioRepository;
import br.com.gestorfinanceiro.repository.filter.UsuarioFilter;
import br.com.gestorfinanceiro.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody UsuarioFilter usuario) {
		Usuario userLogando = usuarioService.login(usuario);
		return userLogando != null ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/usuarioLogado")
	public ResponseEntity<Usuario> userLogado(@RequestBody UsuarioFilter usuario) {
		Usuario userLogando = usuarioRepository.findByEmailESenha(usuario);
		return userLogando != null ? ResponseEntity.ok(userLogando) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Usuario> consultarPorCodigo(@PathVariable Long codigo) {
		return ResponseEntity.ok(usuarioRepository.findById(codigo).get());
	}

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioCriado = usuarioRepository.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioCriado.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
	}

	@PutMapping
	public ResponseEntity<?> atualizarUsuario(@RequestBody Usuario usuario) {
		System.out.println("alguem tentando atualizar");
		Usuario usuarioSalvo = usuarioService.atualizar(usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}

	@DeleteMapping
	public ResponseEntity<?> deletarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.deletar(usuario) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
	}

}
