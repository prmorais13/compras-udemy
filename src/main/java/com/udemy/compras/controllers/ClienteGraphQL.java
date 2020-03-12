package com.udemy.compras.controllers;

import java.util.List;

import javax.transaction.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.models.Cliente;
import com.udemy.compras.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private ClienteService clienteService;

	public Cliente cliente(Integer id) {
		return clienteService.findById(id);
	}

	public List<Cliente> clientes() {
		return clienteService.findAll();
	}

	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteService.save(cliente);
		// return obj;
	}

	@Transactional
	public Boolean deleteCliente(Integer id) {
		return clienteService.deleteById(id);
	}
}