package com.udemy.compras.controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

	public String hello() {
		return "Hello GrahphQL";
	}

	public int soma(int a, int b) {
		return a + b;
	}
}