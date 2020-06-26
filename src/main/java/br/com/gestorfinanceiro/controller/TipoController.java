package br.com.gestorfinanceiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestorfinanceiro.model.Tipo;
import br.com.gestorfinanceiro.repository.TipoRepository;

@RestController
@RequestMapping("/tipo")
public class TipoController {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@GetMapping
	public List<Tipo> listar() {
		
		return tipoRepository.findAll();
		
	}
}
