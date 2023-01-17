package com.example.lab10;

public class Employee {
    private String firstName;
    private String lastName;
    private String employmentDate;

    public Employee(String firstName, String lastName, String employmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }
}
