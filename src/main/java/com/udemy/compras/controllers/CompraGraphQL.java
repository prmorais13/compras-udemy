package com.udemy.compras.controllers;

import java.util.Date;
import java.util.List;

// import javax.transaction.Transactional;

// import com.coxautodev.graphql.tools.GraphQLMutationResolver;
// import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.models.Compra;
import com.udemy.compras.models.InputCompra;
import com.udemy.compras.services.ClienteService;
import com.udemy.compras.services.CompraService;
import com.udemy.compras.services.ProdutoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import io.leangen.graphql.annotations.GraphQLMutation;
// import io.leangen.graphql.annotations.GraphQLQuery;
// import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

// @Component
// public class CompraGraphQL implements GraphQLQueryResolver,
// GraphQLMutationResolver {

public class CompraGraphQL {

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

	public Compra saveCompra(InputCompra input) {
		// Compra newCompra = new Compra();
		// ModelMapper m = new ModelMapper();
		Compra newCompra = new ModelMapper().map(input, Compra.class);

		// newCompra.setId(input.getId());
		// newCompra.setQuantidade(input.getQuantidade());
		// newCompra.setStatus(input.getStatus());
		newCompra.setData(new Date());

		newCompra.setCliente(clienteService.findById(input.getCliente_id()));
		newCompra.setProduto(produtoService.findById(input.getProduto_id()));

		return compraService.save(newCompra);
		// return obj;
	}

	public Boolean deleteCompra(Integer id) {
		return compraService.deleteById(id);
	}
}