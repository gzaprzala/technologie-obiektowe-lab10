package com.example.lab10;

import java.util.ArrayList;
import java.util.List;

class EmployeeRepository {

    private static final List<Employee> employees = new ArrayList<>();

    public List<Employee> findAll() {
        return employees;
    }

    public void save(Employee employee) {
        employees.add(employee);
    }

}
