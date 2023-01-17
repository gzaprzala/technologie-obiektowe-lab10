package com.example.lab10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping("/")
    String home() {
        return "Grzegorz Zaprzala - Technologie Obiektowe LAB10 ----- " +
                "Dostepne sciezki: ----- " +
                "/listofemployees - zwraca liste pracownikow ----- " +
                "/listofemployees/add - dodaje pracownika do listy";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public EmployeeRepository employeeRepository() {
        return new EmployeeRepository();
    }

    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeService(employeeRepository);
    }

}
