package com.came.crud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.came.crud.dao.CarRepo;
import com.came.crud.entities.Car;

@Component
public class CarRoute extends RouteBuilder{
	
	@Autowired
	private CarRepo carRepo;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		restConfiguration().component("servlet");
		rest("/cars")
		.get().to("direct:getcars")
		.get("/{id}").to("direct:getcar")
		.post().to("direct:postcar")
		.put().to("direct:putcar")
		.delete("/{id}").to("direct:deletecar")
		;
		
		//get All Cars
		from("direct:getcars")
		.log("getAllCar")
			.process(exchange->{
				List<Car> li = carRepo.findAll();
				exchange.getIn().setBody(li);
			})
			.marshal().json()
			.log("${body}");
		
		//get Car by Id
		from("direct:getcar")
			.process(exchange->{
				long id = exchange.getIn().getHeader("id",Long.class);
				Optional<Car> car = carRepo.findById(id);
				exchange.getIn().setBody(car.orElse(null));
			})
			.marshal().json().log("${body}");
		
		//post Car
		from("direct:postcar")
		    	.unmarshal().json(JsonLibrary.Jackson, Car.class)
				.process(exchange->{
					Car car = exchange.getIn().getBody(Car.class);
					if(!carRepo.existsById(car.getId())) {
						carRepo.save(car);
						exchange.getIn().setBody("car saved");
					}
					else exchange.getIn().setBody("A car by this id already exist first delete it");
					}).choice()
						.when(body().contains("car saved")).log("car saved")
						.otherwise().log("A car by this id already exist first delete it")
						.end();
		
		//delete car by id
		from("direct:deletecar")
			.process(exchange->{
				Long id = exchange.getIn().getHeader("id",Long.class);
				if(carRepo.existsById(id)) {
					carRepo.deleteById(id);
					exchange.getIn().setBody("Deleted");
				}else{
					exchange.getIn().setBody("Id not present");
				}
			}).choice()
				.when(body().contains("Deleted")).log("Deleted")
				.otherwise().log("Id not present")
				.end();
		
		//put or update car
		from("direct:putcar")
			.unmarshal().json(JsonLibrary.Jackson,Car.class)
			.process(exchange->{
				Car car = exchange.getIn().getBody(Car.class);
				if(carRepo.existsById(car.getId())) {
					carRepo.save(car);
					exchange.getIn().setBody(car+"Updated");
				}
				else exchange.getIn().setBody("No Id exist by this number");
			}).choice()
				.when(body().contains("No Id exist by this number"))
					.log("Id is invalid")
				.otherwise().log("Updated: ${body}")
				.end();
	}

}
