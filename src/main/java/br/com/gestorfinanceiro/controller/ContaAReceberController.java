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
import br.com.gestorfinanceiro.model.ContaAReceber;
import br.com.gestorfinanceiro.repository.ContaAReceberRepository;
import br.com.gestorfinanceiro.repository.filter.ContaAReceberFilter;
import br.com.gestorfinanceiro.service.ContaAReceberService;

@RestController
@RequestMapping("/receber")
public class ContaAReceberController {

	@Autowired
	private ContaAReceberRepository contaRepository;
	@Autowired
	private ContaAReceberService contaService;
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<ContaAReceber> listar() {

		return contaRepository.findAll();

	}

	@PostMapping
	public ResponseEntity<ContaAReceber> criarConta(@RequestBody ContaAReceber contaAReceber,
			HttpServletResponse response) {
		
		ContaAReceber contaAReceberSalva = contaRepository.save(contaAReceber);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, contaAReceberSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(contaAReceber);
		
	}

	@PutMapping
	public ResponseEntity<?> atualizarConta(@RequestBody ContaAReceber contaAReceber, HttpServletResponse response) {
		
		ContaAReceber contaAtualizada = contaService.atualizar(contaAReceber);
		return ResponseEntity.ok(contaAtualizada);
		
	}

	@DeleteMapping
	public ResponseEntity<?> deletarConta(@RequestBody ContaAReceber contaAReceber) {
		
		return contaService.deletar(contaAReceber) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/filtrar")
	public List<ContaAReceber> buscarPorTitulo(@RequestBody ContaAReceberFilter contaFilter) {
		System.out.println(contaFilter.toString());
		return contaService.filtrar(contaFilter);
	}
}
