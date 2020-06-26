package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.model.ContaAPagar;
import br.com.gestorfinanceiro.repository.ContaAPagarRepository;
import br.com.gestorfinanceiro.repository.filter.ContaAPagarFilter;

@Service
public class ContaAPagarService {

	@Autowired
	private ContaAPagarRepository contaRepository;
	
	public ContaAPagar atualizar(ContaAPagar contaAPagar) {
		ContaAPagar contaSalva = contaRepository.findById(contaAPagar.getCodigo()).get();
		if(contaSalva == null) {
			throw new NoSuchElementException();
		}
		return contaRepository.save(contaAPagar);
	}
	
	public boolean deletar(ContaAPagar contaAPagar) {
		if(contaAPagar.getCodigo() != null) {
			contaAPagar.setIndDeletado(true);
			contaRepository.save(contaAPagar);
			return true;
		} else return false;
	}
	
	public List<ContaAPagar> filtrar(ContaAPagarFilter filter) {
		return contaRepository.filtrar(filter);
	}
}
