package com.example.lab10;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/listofemployees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/listofemployees/add")
    public ResponseEntity<Employee> addEmployee(@RequestParam String firstName,
                                                @RequestParam String lastName,
                                                @RequestParam String employmentDate) {
        if(firstName.isEmpty() || lastName.isEmpty() || employmentDate.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Employee employee = new Employee(firstName, lastName, employmentDate);
        employeeService.addEmployee(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

}
