package com.udemy.compras.graphql;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
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