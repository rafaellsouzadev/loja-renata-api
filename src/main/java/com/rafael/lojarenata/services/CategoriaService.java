package com.rafael.lojarenata.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.lojarenata.domain.Categoria;
import com.rafael.lojarenata.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		return cat.orElse(null);
	}

}
