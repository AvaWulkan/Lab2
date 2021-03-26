package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryDouble implements EmployeeRepository{


    @Override
    public List<Employee> findAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("001", 23000));
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }

}
