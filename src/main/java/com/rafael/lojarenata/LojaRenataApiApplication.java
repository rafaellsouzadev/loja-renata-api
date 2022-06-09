package com.rafael.lojarenata;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.lojarenata.domain.Categoria;
import com.rafael.lojarenata.domain.Cidade;
import com.rafael.lojarenata.domain.Cliente;
import com.rafael.lojarenata.domain.Endereco;
import com.rafael.lojarenata.domain.Estado;
import com.rafael.lojarenata.domain.Produto;
import com.rafael.lojarenata.domain.enums.TipoCliente;
import com.rafael.lojarenata.repositories.CategoriaRepository;
import com.rafael.lojarenata.repositories.CidadeRepository;
import com.rafael.lojarenata.repositories.ClienteRepository;
import com.rafael.lojarenata.repositories.EnderecoRepository;
import com.rafael.lojarenata.repositories.EstadoRepository;
import com.rafael.lojarenata.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaRenataApiApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

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
		
		Estado est1 = new Estado(null, "Ceará");
		
		Cidade cid1 = new Cidade(null, "Fortaleza", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		
		estadoRepository.saveAll(Arrays.asList(est1));
		
		cidadeRepository.saveAll(Arrays.asList(cid1));
		
		Cliente cli1 = new Cliente(null, "Rafael de Souza", "rafael-souza4@outlook.com", "73066731065", TipoCliente.PESSOAFISICA);
		cli1.getTelefone().addAll(Arrays.asList("(85) 99230-6668"));
		
		Endereco e1 = new Endereco(null, "Rua Dr. Manoel Moreira", "359", "casa c altos", "Maraponga", "60433213", cli1, cid1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		enderecoRepository.saveAll(Arrays.asList(e1));
		
	}

}
