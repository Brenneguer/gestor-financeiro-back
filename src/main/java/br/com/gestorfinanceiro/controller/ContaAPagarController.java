package br.com.gestorfinanceiro.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorfinanceiro.event.RecursoCriadoEvent;
import br.com.gestorfinanceiro.model.ContaAPagar;
import br.com.gestorfinanceiro.repository.ContaAPagarRepository;
import br.com.gestorfinanceiro.repository.filter.ContaAPagarFilter;
import br.com.gestorfinanceiro.service.ContaAPagarService;

@RestController
@RequestMapping("/pagar")
public class ContaAPagarController {

	@Autowired
	private ContaAPagarRepository contaRepository;
	@Autowired
	private ContaAPagarService contaService;
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<ContaAPagar> listar() {
		
		return contaRepository.findAll();
		
	}

	@PostMapping
	public ResponseEntity<ContaAPagar> criarConta(@RequestBody ContaAPagar contaAPagar, HttpServletResponse response) {
		System.out.println(contaAPagar);
		ContaAPagar contaAPagarSalva = contaRepository.save(contaAPagar);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, contaAPagarSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(contaAPagarSalva);

	}

	@PutMapping
	public ResponseEntity<ContaAPagar> atualizarConta(@RequestBody ContaAPagar contaAPagar,
			HttpServletResponse response) {
		
		ContaAPagar contaSalva = contaService.atualizar(contaAPagar);
		return ResponseEntity.ok(contaSalva);
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletarConta(@RequestBody ContaAPagar contaAPagar) {
		
		return contaService.deletar(contaAPagar) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/filtrar")
	public List<ContaAPagar> filtrar(@RequestBody ContaAPagarFilter filter) {
		return contaService.filtrar(filter);	
	}
	
}
