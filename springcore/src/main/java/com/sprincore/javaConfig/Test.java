package com.sprincore.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        // Correcting the context initialization to pass the class reference, not a string
        ApplicationContext context = new AnnotationConfigApplicationContext(javaConfig.class);

        // Retrieve the Student bean from the Spring context
        Student student = context.getBean(Student.class);

        // Call the display method on the Student bean
        student.display();  // This should print "In student" to the console
    }
}
