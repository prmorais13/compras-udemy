package com.udemy.compras.services;

import java.util.List;

import javax.transaction.Transactional;

import com.udemy.compras.models.Produto;
import com.udemy.compras.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Produto save(Produto produto) {
		return repository.save(produto);
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