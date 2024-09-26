package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getempId(Integer empId){
        //Employee employee=employeeRepository.getById(empId);
        return employeeRepository.findById(empId).orElse(null);
    }

    public void deleteById(Integer empId){
        employeeRepository.deleteById(empId);
    }

    public Employee updateEmployee(Integer empId,Employee employee){
        Employee employee1=employeeRepository.findById(empId).orElse(null);
        if (employee1 != null) {
            employee1.setEmpName(employee.getEmpName());
            employee1.setRole(employee.getRole());
            employee1.setContact(employee.getContact());
            employeeRepository.save(employee1);
        }
        return employee1;
    }

}
