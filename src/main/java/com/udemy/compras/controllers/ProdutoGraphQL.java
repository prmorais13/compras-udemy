package com.udemy.compras.controllers;

import java.util.List;

import javax.transaction.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.models.Produto;
import com.udemy.compras.models.ProdutoInput;
import com.udemy.compras.services.ProdutoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private ProdutoService produtoService;

	public Produto produto(Integer id) {
		return produtoService.findById(id);
	}

	public List<Produto> produtos() {
		return produtoService.findAll();
	}

	@Transactional
	public Produto saveProduto(ProdutoInput input) {
		return produtoService.save(new ModelMapper().map(input, Produto.class));
		// return obj;
	}

	@Transactional
	public Boolean deleteProduto(Integer id) {
		return produtoService.deleteById(id);
	}
}