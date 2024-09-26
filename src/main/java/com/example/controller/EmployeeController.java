package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @MutationMapping
    public Employee create(@Argument String empName,
                           @Argument String role,
                            @Argument String contact){
         Employee employee=new Employee();
         employee.setEmpName(empName);
         employee.setRole(role);
         employee.setContact(contact);
         return employeeService.create(employee);
     }
     @QueryMapping
     public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
     }

    @QueryMapping
    public Employee getById(@Argument Integer empId){
        return employeeService.getempId(empId);
    }

    @MutationMapping
    public void delete(@Argument Integer empId){
        employeeService.deleteById(empId);
    }

    @MutationMapping
    public Employee update(@Argument Integer empId,@Argument String empName,
                           @Argument String role,
                           @Argument String contact){
        Employee employee=new Employee();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setRole(role);
        employee.setContact(contact);
        return employeeService.updateEmployee(empId,employee);

    }













}
