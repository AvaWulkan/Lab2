package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class EmployeeManagerTest {
    String ID = "001";
    double SALARY = 23000;

    @Test
    void payEmployeesDoublesTest(){
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
        employees.add(new Employee(ID, SALARY));
        when(mockRepo.findAll()).thenReturn(employees);

        int expected = 1;
        boolean expectedPaid = true;
        int actual = testObject.payEmployees();
        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(expectedPaid, employees.get(0).isPaid());
    }

    @Test
    void payEmployeesMockitoNoEmployeesTest(){
        EmployeeRepository mockRepo = mock(EmployeeRepository.class);
        EmployeeManager testObject = new EmployeeManager(mockRepo,mock(BankService.class));

        ArrayList<Employee> employees = new ArrayList<>();
        when(mockRepo.findAll()).thenReturn(employees);

        int expected = 0;
        int actual = testObject.payEmployees();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void payEmployeesMockitoExceptionTest(){
        EmployeeRepository mockRepo = mock(EmployeeRepository.class);
        BankService mockBank = mock(BankService.class);
        EmployeeManager testObject = new EmployeeManager(mockRepo,mockBank);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(ID, SALARY));
        when(mockRepo.findAll()).thenReturn(employees);
        doThrow(new RuntimeException()).when(mockBank).pay(ID, SALARY);

        int expectedPayments = 0;
        boolean expectedPaid = false;
        int actual = testObject.payEmployees();

        Assertions.assertEquals(expectedPayments, actual);
        Assertions.assertEquals(expectedPaid, employees.get(0).isPaid());
    }

}