package com.test.controller;

import com.test.model.Employee;
import com.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @PostMapping("/add")
    @Transactional
    public List<Employee> add(@RequestBody @Valid Employee employee) {
        repository.save(employee);
        return repository.findAll();
    }

    @GetMapping("/date")
    public String date(@RequestParam(name = "start")
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start) {
        return start.toString();
    }
}
