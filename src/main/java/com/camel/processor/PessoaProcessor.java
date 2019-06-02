package com.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.camel.domain.PessoasXML;

public class PessoaProcessor implements Processor {
	
	public void process(Exchange exchange) throws Exception {
		PessoasXML listPessoas = exchange.getIn().getBody(PessoasXML.class);
		exchange.getIn().setBody(listPessoas);
		System.out.println("LISTA PROCESS --------------------" + listPessoas);
	}

}
