package com.camel.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pessoa")
public class PessoaXML {
	
	private String nome;
	private int idade;
	
	public PessoaXML () {
		
	}
	
	public PessoaXML (String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	@XmlElement
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@XmlElement
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

}
