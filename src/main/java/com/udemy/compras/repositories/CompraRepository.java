package com.udemy.compras.repositories;

import java.util.List;

import com.udemy.compras.models.Cliente;
import com.udemy.compras.models.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

	List<Compra> findAllByCliente(Cliente c);

}