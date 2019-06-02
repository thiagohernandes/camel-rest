package com.camel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camel.domain.Pessoa;
import com.camel.domain.PessoasXML;
import com.camel.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping("/json")
	public List<Pessoa> allPessoas(){
		return service.allPessoas();
	}
	
	@RequestMapping(value="/xml", produces=MediaType.APPLICATION_XML_VALUE)
	public PessoasXML allPessoasXML(){
		return service.allPessoasXML();
	}
	
}
