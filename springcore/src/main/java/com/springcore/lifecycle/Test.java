package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("com/springcore/lifecycle/lifeConfig.xml");
		 */
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/lifeConfig.xml");
		Choclate choclate1 = (Choclate)context.getBean("choclate1");
		System.out.println(choclate1);
		
		//using to call destroy method also astractApplica...
		context.registerShutdownHook();
		
		System.out.println("+++");
		Pepsi pepsi = (Pepsi)context.getBean("pepsi");
		System.out.println(pepsi);
		
	}
}
