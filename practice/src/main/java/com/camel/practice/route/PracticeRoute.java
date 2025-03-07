package com.camel.practice.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PracticeRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
//		below is simple file transfer
		from("file:D://camelPractice/input/")
		.
	    .to("file:D://camelPractice/output/");
		
	}

}
