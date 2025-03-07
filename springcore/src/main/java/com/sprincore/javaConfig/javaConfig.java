package com.sprincore.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class javaConfig {

    // Define the bean for Student
    @Bean
    public Student getStudent() {
        return new Student();
    }
}
