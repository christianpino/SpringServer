package com.genuinecoder.springserver.springserver.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDao {
    @Autowired
    private EmployeeRepository repository;
    public Employee save(Employee employee) {
        repository.save(employee);
        return employee;
    }
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(employees::add);
        return employees;
    }
    public void delete(int employeeId) {
        repository.deleteById(employeeId);
    }
}