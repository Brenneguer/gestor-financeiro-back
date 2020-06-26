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
import br.com.gestorfinanceiro.model.Categoria;
import br.com.gestorfinanceiro.repository.CategoriaRepository;
import br.com.gestorfinanceiro.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Categoria> listar() {

		return categoriaRepository.listar();

	}

	@PostMapping
	public ResponseEntity<Categoria> novaCategoria(@RequestBody Categoria categoria, HttpServletResponse response) {

		Categoria categoriaSalva = categoriaRepository.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);

	}

	@PutMapping()
	public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria,
			HttpServletResponse response) {

		Categoria categoriaSalva = categoriaService.atualizar(categoria);
		return ResponseEntity.ok(categoriaSalva);

	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> deletarCategoria(@PathVariable Long codigo, HttpServletResponse response) {
		System.out.println("tentando deletar");
		Categoria categoria = categoriaRepository.findById(codigo).get();
		return categoriaService.deletar(categoria) ? ResponseEntity.ok(categoria.isIndDeletado()) : ResponseEntity.badRequest().build();
	}

	@GetMapping("/filtrar/{tipo}")
	public List<Categoria> filtrarTipo(@PathVariable String tipo) {
		return categoriaService.removerDeletados(categoriaRepository.filtrarTipo(tipo));
	}


}
