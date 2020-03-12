package com.udemy.compras.controllers;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.models.Compra;
import com.udemy.compras.models.CompraInput;
import com.udemy.compras.services.ClienteService;
import com.udemy.compras.services.CompraService;
import com.udemy.compras.services.ProdutoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private CompraService compraService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	public Compra compra(Integer id) {
		return compraService.findById(id);
	}

	public List<Compra> compras() {
		return compraService.findAll();
	}

	@Transactional
	public Compra saveCompra(CompraInput input) {
		// ModelMapper m = new ModelMapper();
		Compra newCompra = new ModelMapper().map(input, Compra.class);
		newCompra.setData(new Date());

		newCompra.setCliente(clienteService.findById(input.getCliente_id()));
		newCompra.setProduto(produtoService.findById(input.getProduto_id()));

		return compraService.save(newCompra);
		// return obj;
	}

	@Transactional
	public Boolean deleteCompra(Integer id) {
		return compraService.deleteById(id);
	}
}