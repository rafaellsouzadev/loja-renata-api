package com.rafael.lojarenata;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.rafael.lojarenata.domain.ItemPedido;
import com.rafael.lojarenata.domain.Pagamento;
import com.rafael.lojarenata.domain.PagamentoAvistaOuPix;
import com.rafael.lojarenata.domain.PagamentoComCartao;
import com.rafael.lojarenata.domain.Pedido;
import com.rafael.lojarenata.domain.Produto;
import com.rafael.lojarenata.domain.enums.EstadoPagamento;
import com.rafael.lojarenata.domain.enums.TipoCliente;
import com.rafael.lojarenata.repositories.CategoriaRepository;
import com.rafael.lojarenata.repositories.CidadeRepository;
import com.rafael.lojarenata.repositories.ClienteRepository;
import com.rafael.lojarenata.repositories.EnderecoRepository;
import com.rafael.lojarenata.repositories.EstadoRepository;
import com.rafael.lojarenata.repositories.ItemPedidoRepository;
import com.rafael.lojarenata.repositories.PagamentoRepository;
import com.rafael.lojarenata.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("10/06/2022 10:08"), cli1, e1);
		
		Pedido ped2 = new Pedido(null, sdf.parse("22/06/2022 08:00"), cli1, e1);
		
		Pagamento pagto1 = new PagamentoAvistaOuPix(null, EstadoPagamento.QUITADO, ped2, sdf.parse("22/06/2022 08:30"));
		ped2.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComCartao(null, EstadoPagamento.PENDENTE, ped1, 3);
		ped1.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped2, p4, BigDecimal.ZERO, 1,new BigDecimal(11.90));
		
		ItemPedido ip2 = new ItemPedido(ped1, p2, BigDecimal.ZERO, 2, new BigDecimal(9.50));
		
		ped1.getItens().addAll(Arrays.asList(ip2));
		ped2.getItens().addAll(Arrays.asList(ip1));
		
		p2.getItens().addAll(Arrays.asList(ip2));
		p4.getItens().addAll(Arrays.asList(ip1));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2));
		
	}

}
