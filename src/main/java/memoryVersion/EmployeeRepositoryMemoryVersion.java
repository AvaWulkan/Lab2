package memoryVersion;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryMemoryVersion implements EmployeeRepository {

    private ArrayList<Employee> allEmployees = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return allEmployees;
    }

    @Override
    public Employee save(Employee e) {
        allEmployees.add(e);
        return allEmployees.get(allEmployees.size()-1);
    }

}
