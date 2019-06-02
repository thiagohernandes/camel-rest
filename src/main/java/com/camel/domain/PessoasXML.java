package com.camel.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pessoas")
public class PessoasXML {

	private List<PessoaXML> listPessoas = new ArrayList<>();

	public List<PessoaXML> getPessoas() {
		return listPessoas;
	}

	@XmlElement(name = "pessoa")
	public void setPessoas(List<PessoaXML> pessoas) {
		this.listPessoas = pessoas;
	}
	
	
}
