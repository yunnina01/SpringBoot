package org.example.springbootblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootBlogApplication.class, args);
    }
}
