package com.udemy.compras.resolvers;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;
import com.udemy.compras.services.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

	@Autowired
	private CompraService compraService;

	public String status(Compra c) {
		return "Teste: " + c.getStatus();
	}

	public List<Compra> compras(Cliente c) {
		return compraService.findAllByCliente(c);

	}

}