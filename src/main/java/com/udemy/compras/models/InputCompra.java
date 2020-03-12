package com.udemy.compras.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class InputCompra implements Serializable {

	@JsonIgnore
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date data;
	private Integer quantidade;
	private String status;

	private Integer cliente_id;
	private Integer produto_id;

}