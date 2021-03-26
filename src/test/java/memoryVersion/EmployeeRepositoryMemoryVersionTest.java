package memoryVersion;

import com.example.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EmployeeRepositoryMemoryVersionTest {
    String ID = "001";
    int SALARY = 23000;
    int SALARY_2 = 30000;

    @Test
    void findAllEmptyTest(){
        EmployeeRepositoryMemoryVersion testObject = new EmployeeRepositoryMemoryVersion();

        ArrayList<Employee> expected = new ArrayList<>();
        ArrayList<Employee> actual = new ArrayList<>(testObject.findAll());

        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void saveTest(){
        EmployeeRepositoryMemoryVersion testObject = new EmployeeRepositoryMemoryVersion();

        Employee expected = new Employee(ID, SALARY);
        Employee actual = testObject.save(new Employee(ID, SALARY));

        Assertions.assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void findAllAndSaveTest(){
        EmployeeRepositoryMemoryVersion testObject = new EmployeeRepositoryMemoryVersion();

        ArrayList expected = new ArrayList();
        expected.add(new Employee(ID, SALARY));

        testObject.save(new Employee(ID, SALARY));

        ArrayList actual = new ArrayList(testObject.findAll());

        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void SaveSameIdTest(){
        EmployeeRepositoryMemoryVersion testObject = new EmployeeRepositoryMemoryVersion();

        Employee expected = new Employee(ID, SALARY);
        Employee actual = testObject.save(new Employee(ID, SALARY));

        Assertions.assertEquals(expected.toString(),actual.toString());

        expected = new Employee(ID, SALARY_2);
        actual = testObject.save(new Employee(ID, SALARY_2));

        Assertions.assertEquals(expected.toString(),actual.toString());
    }

    @Test
    void InitialiseWithListTest(){
        ArrayList initalizingLIst = new ArrayList();
        initalizingLIst.add(new Employee(ID,SALARY));
        EmployeeRepositoryMemoryVersion testObject = new EmployeeRepositoryMemoryVersion(initalizingLIst);

        ArrayList<Employee> expected = new ArrayList<>();
        expected.add(new Employee(ID, SALARY));
        ArrayList<Employee> actual = new ArrayList<>(testObject.findAll());

        Assertions.assertEquals(expected.toString(),actual.toString());
    }

}
