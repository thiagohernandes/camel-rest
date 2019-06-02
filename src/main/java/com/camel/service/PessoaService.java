package com.camel.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.camel.domain.Pessoa;
import com.camel.domain.PessoaXML;
import com.camel.domain.PessoasXML;

@Service
public class PessoaService {

	public List<Pessoa> allPessoas() {
		return Arrays.asList(new Pessoa("Beltrano", 22), new Pessoa("Alana", 27), new Pessoa("Filisbino", 39));
	}
	
	public PessoasXML allPessoasXML() {
		PessoasXML pessoas = new PessoasXML();
		pessoas.setPessoas(Arrays.asList(new PessoaXML("Beltrano", 22), new PessoaXML("Alana", 27), new PessoaXML("Filisbino", 39)));
		return pessoas;
	}
	
}
