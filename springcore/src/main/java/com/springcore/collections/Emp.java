package com.springcore.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Emp {
	private String name;
	private List <String> phones;
	private List <String> phone2;
	private Set<String> address;
	private Map<String, String> courses;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public List<String> getPhone2() {
		return phone2;
	}
	public void setPhone2(List<String> phone2) {
		this.phone2 = phone2;
	}
	public Set<String> getAddress() {
		return address;
	}
	public void setAddress(Set<String> address) {
		this.address = address;
	}
	public Map<String, String> getCourses() {
		return courses;
	}
	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", phones=" + phones + ", phone2=" + phone2 + ", address=" + address + ", courses="
				+ courses + "]";
	}
	
	
}
