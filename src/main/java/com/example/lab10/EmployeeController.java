package com.example.lab10;

import java.util.List;

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
    public void addEmployee(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String employmentDate) {
        Employee employee = new Employee(firstName, lastName, employmentDate);
        employeeService.addEmployee(employee);
    }

}
