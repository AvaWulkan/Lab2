package memoryVersion;

import com.example.BankService;
import com.example.Employee;
import com.example.EmployeeManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class EmployeeManagerIT {

    String ID = "001";
    int SALARY = 23000;

    @Test
    void EmployeeManagerIT(){
        BankService mockBank = mock(BankService.class);
        EmployeeManager testObject = new EmployeeManager(new EmployeeRepositoryMemoryVersion(), mockBank);

        int expected = 0;
        int actual = testObject.payEmployees();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void EmployeeManagerCallRepoWithLIstIT(){
        ArrayList<Employee> initalizingLIst = new ArrayList<>();
        initalizingLIst.add(new Employee(ID, SALARY));
        BankService mockBank = mock(BankService.class);
        EmployeeManager testObject = new EmployeeManager(new EmployeeRepositoryMemoryVersion(initalizingLIst), mockBank);

        int expected = 1;
        int actual = testObject.payEmployees();

        Assertions.assertEquals(expected,actual);
    }
}
