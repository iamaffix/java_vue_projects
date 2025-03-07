package com.springcore.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("st")
public class Student {
	@Value("Mukkadar ka Sikandar")
	private String name;
	@Value("paatna naa")
	private String city;
	@Value("16")
	private int id;
	
	@Value("#{temp}")
	private List<String> address;
	
	@Value("#{T(java.lang.Math).sqrt(144)}")
	private int number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getAddress() {
		return address;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setAddress(List<String> list) {
		this.address = list;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + ", id=" + id + ", list=" + address +"number"+number+ "]";
	}
	
	
}
