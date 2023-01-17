package com.example.lab10;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void whenAddEmployeeReturn201() throws Exception {
        Employee employee = new Employee("Grzegorz", "Zaprzala", "17/01/2023");

        mockMvc.perform(post("/listofemployees/add")
                        .param("firstName", employee.getFirstName())
                        .param("lastName", employee.getLastName())
                        .param("employmentDate", employee.getEmploymentDate()))
                .andExpect(status().isCreated());

        verify(employeeService, times(1)).addEmployee(argThat(arg ->
                arg.getFirstName().equals(employee.getFirstName())
                && arg.getLastName().equals(employee.getLastName())
                && arg.getEmploymentDate().equals(employee.getEmploymentDate())));
    }

    @Test
    public void whenAddEmployeeWithInvalidDataReturn400() throws Exception {
        mockMvc.perform(post("/listofemployees/add")
                        .param("firstName", "")
                        .param("lastName", "")
                        .param("employmentDate", ""))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenGetEmployeesReturn200() throws Exception {
        Employee employee1 = new Employee("Grzegorz","Zaprzala","17/01/2023");
        Employee employee2 = new Employee("Marcin","Kowalski","18/01/2023");

        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        mockMvc.perform(get("/listofemployees"))
                .andExpect(status().isOk());
        verify(employeeService, times(1)).getAllEmployees();
    }
}