package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    @Test
    void payEmployeesTest(){
        EmployeeManager testObject = new EmployeeManager(new EmployeeRepositoryDouble(), new BankServiceDouble());

        int expected = 1;
        int actual = testObject.payEmployees();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void payEmployeesMockitoTest(){
        EmployeeRepository mockRepo = mock(EmployeeRepository.class);
        EmployeeManager testObject = new EmployeeManager(mockRepo,mock(BankService.class));
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("001", 23000));
        when(mockRepo.findAll()).thenReturn(employees);

        int expected = 1;
        int actual = testObject.payEmployees();
        Assertions.assertEquals(expected,actual);
    }

}