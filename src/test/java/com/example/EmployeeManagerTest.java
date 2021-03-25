package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeManagerTest {

    @Test
    void payEmployeesTest(){
        EmployeeManager testObject = new EmployeeManager(new EmployeeRepositoryDouble(), new BankServiceDouble());

        int expected = 1;
        int actual = testObject.payEmployees();
        Assertions.assertEquals(expected,actual);
    }

}