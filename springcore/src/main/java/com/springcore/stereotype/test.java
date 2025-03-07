package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/stereotype/stereotypeConfig.xml");
		Student s1=(Student) context.getBean("st");
		System.out.println(s1);
		System.out.println("Hashcode of Singelton student 1: "+s1.hashCode());
		Student s2 = (Student)context.getBean("st");
		System.out.println("Hashcode of Singelton student 2: "+s2.hashCode());
		System.out.println("++++++++++++++++++++++++++");
		
		Teacher t1 = (Teacher)context.getBean("Teacher");
		Teacher t2 = (Teacher)context.getBean("Teacher");
		System.out.println("Hashcode of prototype teacher 1: "+t1.hashCode());
		System.out.println("Hashcode of prototype teacher 2: "+t2.hashCode());
	}
}
