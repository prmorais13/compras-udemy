package com.udemy.compras.graphql;

import java.util.List;

import javax.transaction.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.Cliente;
import com.udemy.compras.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente cliente(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> clientes() {
		return clienteRepository.findAll();
	}

	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		// Cliente novoCliente = new Cliente(cliente.getId(), cliente.getNome(),
		// cliente.getEmail());
		Cliente obj = clienteRepository.save(cliente);
		return obj;
	}
}