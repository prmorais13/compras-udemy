package com.udemy.compras.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ClienteInput implements Serializable {
	@JsonIgnore
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
}