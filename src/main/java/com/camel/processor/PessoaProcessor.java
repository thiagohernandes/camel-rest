package com.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.JSONArray;
import org.json.XML;

public class PessoaProcessor implements Processor {
	
	private final String beginPessoas = "<pessoas>";
	private final String endPessoas = "</pessoas>";
	private final String headerXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	
	public void process(Exchange exchange) throws Exception {
		System.out.println("PROCESSOR " + exchange.getIn().getBody());
		JSONArray array = new JSONArray(exchange.getIn().getBody().toString());
	    String xml = XML.toString(array, "pessoa");
	    System.out.println("AFTER PROCESSOR " + headerXML + beginPessoas+ xml + endPessoas);
		
	}

}
