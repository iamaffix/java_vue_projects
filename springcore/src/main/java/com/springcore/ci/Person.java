package com.springcore.ci;

import java.util.List;

import com.springcore.Student;

public class Person{
	private String name;
	private int personId;
	private Student student;
	private List<String> friends;
	
	public Person(String name, int personId,Student student,List<String> friends) {
		this.name = name;
		this.personId = personId;
		this.student = student;
		this.friends = friends;
	}
	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name+": "+this.personId+" "+student.toString()+" "+friends.toString();
	}
}