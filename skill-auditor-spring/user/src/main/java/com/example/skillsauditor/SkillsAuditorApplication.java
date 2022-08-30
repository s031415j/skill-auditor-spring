package com.example.skillsauditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"com.example.skillsauditor.*"})
@EntityScan("com.example.skillsauditor")
//@SpringBootApplication(scanBasePackages = {"com.example.skillsauditor.*"})
@SpringBootApplication
public class SkillsAuditorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillsAuditorApplication.class, args);
    }

}
