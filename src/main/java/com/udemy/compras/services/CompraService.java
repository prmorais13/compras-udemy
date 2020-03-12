package com.udemy.compras.services;

import java.util.List;

import javax.transaction.Transactional;

import com.udemy.compras.models.Compra;
import com.udemy.compras.repositories.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CompraService {

	@Autowired
	private CompraRepository repository;

	public Compra findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Compra> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Compra save(Compra compra) {
		return repository.save(compra);
		// return obj;
	}

	@Transactional
	public Boolean deleteById(Integer id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}