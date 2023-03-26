package org.siit.homework.week11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@EntityScan(basePackages = "org.siit.homework.week11.entity")
public class Main {
    public static void main(String[] args) {

        System.out.println("This is the main class for week 11 homework");
        System.out.println();

        SpringApplication.run(Main.class, args);
    }
}
