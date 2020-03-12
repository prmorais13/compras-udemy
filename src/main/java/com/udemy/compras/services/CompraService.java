package com.udemy.compras.services;

import java.util.List;

// import javax.transaction.Transactional;

import com.udemy.compras.models.Compra;
import com.udemy.compras.repositories.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class CompraService {

	@Autowired
	private CompraRepository repository;

	@GraphQLQuery(name = "compraById")
	public Compra findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@GraphQLQuery(name = "allCompras")
	public List<Compra> findAll() {
		return repository.findAll();
	}

	// @Transactional
	@GraphQLMutation(name = "createCompra")
	public Compra save(Compra compra) {
		return repository.save(compra);
		// return obj;
	}

	public Boolean deleteById(Integer id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}