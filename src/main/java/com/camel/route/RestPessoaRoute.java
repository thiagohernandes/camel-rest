package com.camel.route;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.camel.domain.Pessoa;
import com.camel.domain.PessoasXML;
import com.camel.processor.PessoaProcessor;

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

		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Pessoa.class);

		from(localhost8081)
			.to(localhost8080XML+"?bridgeEndpoint=true")
			// .to(localhost8080JSON+"?bridgeEndpoint=true")
			.log(" LOG ---------> ${body}")
				.doTry()
			//	.unmarshal(xmlDataFormat)
		        .process(new PessoaProcessor())
		        .marshal(jsonDataFormat)
		        //.to(localhost8081)
		        .doCatch(Exception.class)
		        	.process(new Processor() {
						public void process(Exchange exchange) throws Exception {
							Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
							System.out.println(cause);
						}
		        	})
			.log(" LOG ---------> ${body}");
		
	}
}
