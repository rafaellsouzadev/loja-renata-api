package com.rafael.lojarenata.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.lojarenata.domain.Cliente;
import com.rafael.lojarenata.repositories.ClienteRepository;
import com.rafael.lojarenata.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente find(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrato! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
