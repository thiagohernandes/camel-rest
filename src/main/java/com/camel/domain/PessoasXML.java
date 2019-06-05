package com.camel.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pessoas")
@XmlAccessorType(XmlAccessType.FIELD)
public class PessoasXML {

	private List<PessoaXML> lista = new ArrayList<>();

	public List<PessoaXML> getPessoas() {
		return lista;
	}

	@XmlElement(name = "pessoa")
	public void setPessoas(List<PessoaXML> lista) {
		this.lista = lista;
	}
	
	
}
