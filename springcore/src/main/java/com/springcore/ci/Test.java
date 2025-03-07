package com.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ci/ciConfig.xml");
		Person person1 = (Person)context.getBean("Person");
		System.out.println(person1);
		Person person2 = (Person)context.getBean("Person2");
		System.out.println(person2);
	}
}
