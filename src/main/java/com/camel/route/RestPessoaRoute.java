package com.camel.route;

import java.util.List;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.camel.domain.Pessoa;
import com.camel.domain.PessoasXML;
import com.camel.processor.PessoaProcessor;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
@Configuration
public class RestPessoaRoute extends RouteBuilder{

	private final String localhost8081 = "jetty://http://localhost:8081/jetty1";
	private final String localhost8080XML = "jetty://http://localhost:8080/api/xml";
	private final String localhost8080JSON = "jetty://http://localhost:8080/api/json";
	
	@Override
	public void configure() throws Exception {

		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(PessoasXML.class);
		xmlDataFormat.setContext(con);
		
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat();

		// XML TO JSON
		JacksonDataFormat jacksonDataFormat = new JacksonDataFormat();
	    jacksonDataFormat.setPrettyPrint(true);
	    
	    // JSON TO XML
	    JacksonDataFormat jacksonDataFormat2 = new JacksonDataFormat();
	    jacksonDataFormat2.setPrettyPrint(true);
	    jacksonDataFormat2.enableFeature(SerializationFeature.WRAP_ROOT_VALUE); // WRAP_ROOT_VALUE
	    
	    
	 // JSON TO XML (NO PROCESSOR) -------------------------------------------------------------------
	    
	    JacksonDataFormat foramat = new ListJacksonDataFormat(PessoasXML.class);
	    
	    from(localhost8081)
		.to(localhost8080JSON+"?bridgeEndpoint=true")
		.convertBodyTo(String.class)
		.log(" LOG 1 ---------> ${body}")
			.doTry()
			.process(new PessoaProcessor())
	        .doCatch(Exception.class)
	        	.process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
						System.out.println(cause);
					}
	        	});
		
	// XML TO JSON -------------------------------------------------------------------
		
//		from(localhost8081)
//		.to(localhost8080XML+"?bridgeEndpoint=true")
//		.log(" LOG 1 ---------> ${body}")
//			.doTry()
//			    .unmarshal(xmlDataFormat)
//		        .process(new PessoaProcessor())
//		        .marshal(jacksonDataFormat)
//		        .log(" LOG 2 ---------> ${body}")
//	        .doCatch(Exception.class)
//	        	.process(new Processor() {
//					public void process(Exchange exchange) throws Exception {
//						Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
//						System.out.println(cause);
//					}
//	        	});
	}
}
