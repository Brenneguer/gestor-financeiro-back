package br.com.gestorfinanceiro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestorfinanceiro.model.Categoria;
import br.com.gestorfinanceiro.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private 	CategoriaRepository categoriaRepository;	
	
	
	public Categoria atualizar(Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.findById(categoria.getCodigo()).get();
		if(categoriaSalva == null) {
			throw new NoSuchElementException();
		}
		return categoriaRepository.save(categoria);
	}
	
	public boolean deletar(Categoria categoria) {
		if (categoria.getCodigo() != null) {
			categoria.setIndDeletado(true);
			categoriaRepository.save(categoria);
			return true;
		} else return false;
	}
	
	public List<Categoria> removerDeletados(List<Categoria> lista) {
		List<Categoria> naoDeletados = new ArrayList<Categoria>();
		for (Categoria categoria : lista) {
			if(!categoria.isIndDeletado()) {
				System.out.println(categoria.getNome() + ": " + categoria.isIndDeletado());
				naoDeletados.add(categoria);
			}
		}
		return naoDeletados;
	}
}
