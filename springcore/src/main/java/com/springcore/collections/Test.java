package com.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/collections/collectionsConfig.xml");
		Emp emp1 = (Emp)context.getBean("emp");
		System.out.println(emp1);
	}
}
