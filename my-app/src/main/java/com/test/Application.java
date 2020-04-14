package com.test;

import com.test.model.Employee;
import com.test.repository.EmployeeRepository;
import com.test.service.TestingProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    EmployeeRepository repository;
    @Autowired
    TestingProfile testingProfile;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        System.out.println(testingProfile.greeting());
        Employee e = new Employee();
        e.setName("Venkat");
        e.setAge(10);
        e.setAddress("USA");
        repository.save(e);
        repository.findAll().forEach(System.out::println);
    }
}
