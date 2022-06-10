package com.rafael.lojarenata.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.rafael.lojarenata.domain.enums.EstadoPagamento;

@Entity
public class PagamentoAvistaOuPix extends Pagamento{

	private static final long serialVersionUID = 1L;
	
	private Date dataPagamento;
	
	public PagamentoAvistaOuPix() {	}

	public PagamentoAvistaOuPix(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	

}
