package com.rafael.lojarenata;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.lojarenata.domain.Categoria;
import com.rafael.lojarenata.domain.Produto;
import com.rafael.lojarenata.repositories.CategoriaRepository;
import com.rafael.lojarenata.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaRenataApiApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LojaRenataApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Limpeza");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Produto p1 = new Produto(null, "Lava louças ISIS", new BigDecimal(9.50), "Lava Louça Maçã 5L", 1.5, 0.60, 0.80, null, 20, 4, null, Boolean.FALSE, null, Boolean.TRUE);
		Produto p2 = new Produto(null, "Lava Louças ISIS", new BigDecimal(9.50), "Laca Louça 5L", 1.5, 0.60, 0.80, null, 20, 4, null, Boolean.FALSE, null, Boolean.TRUE);
		Produto p3 = new Produto(null, "Sabonete Liquido Neutro", new BigDecimal(9.50), "Sabonete Liquido Neutro 1L ", 1.2, 0.60, 0.80, null, 20, 4, null, Boolean.FALSE, null, Boolean.TRUE);
		Produto p4 = new Produto(null, "Aroeira Feminino", new BigDecimal(11.90), "Sabonete Liquido Aroeira Feminino Força da natureza", 1.2, 0.60, 0.80, null, 20, 4, null, Boolean.FALSE, null, Boolean.TRUE);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3,p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		
		
		
	}

}
