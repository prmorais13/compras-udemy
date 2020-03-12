package com.udemy.compras.controllers;

import java.util.List;

import javax.transaction.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.models.Produto;
import com.udemy.compras.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
	public Produto saveProduto(Produto produto) {
		return produtoService.save(produto);
		// return obj;
	}

	@Transactional
	public Boolean deleteProduto(Integer id) {
		return produtoService.deleteById(id);
	}
}