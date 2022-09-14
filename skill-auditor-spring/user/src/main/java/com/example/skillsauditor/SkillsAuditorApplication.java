package com.example.skillsauditor;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.example.skillsauditor")
@SpringBootApplication
@EnableRabbit
public class SkillsAuditorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillsAuditorApplication.class, args);
    }

}
