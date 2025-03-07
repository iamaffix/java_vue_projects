package com.camel.practice.processor;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PracticeProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		from("file:D://camelPractice/input/")
        .process(new ExcludeFilesProcessor())  // Apply the processor to filter files
        .choice()
            .when(header("excludeFile").isEqualTo(true))  // If the file is marked for exclusion
                .log("Excluding file: ${header.CamelFileName}")
                .stop()  // Stop processing the file
            .otherwise()  // If the file is not excluded
                .to("file:D://camelPractice/output/")  // Move it to the output directory
        .end();
	}

}
