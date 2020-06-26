package br.com.gestorfinanceiro.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.model.ContaAReceber;
import br.com.gestorfinanceiro.repository.ContaAReceberRepository;
import br.com.gestorfinanceiro.repository.filter.ContaAReceberFilter;

@Service
public class ContaAReceberService {

	@Autowired
	private ContaAReceberRepository contaRepository;
	
	public ContaAReceber atualizar(ContaAReceber conta) {
		ContaAReceber contaSalva = contaRepository.findById(conta.getCodigo()).get();
		if(contaSalva == null) {
			throw new NoSuchElementException();
		}
		return contaRepository.save(conta);
	}
	
	public boolean deletar(ContaAReceber contaAReceber) {
		if(contaAReceber.getCodigo() != null) {
			contaAReceber.setIndDeletado(true);
			contaRepository.save(contaAReceber);
			return true;
		} else return false;
	}
	
	public List<ContaAReceber> filtrar(ContaAReceberFilter filter) {
		return contaRepository. filtrar(filter);
	}
}
