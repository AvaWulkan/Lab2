package memoryVersion;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryMemoryVersion implements EmployeeRepository {

    private ArrayList<Employee> allEmployees = new ArrayList<>();

    public EmployeeRepositoryMemoryVersion(){}

    public EmployeeRepositoryMemoryVersion(List<Employee> e){
        allEmployees.addAll(e);
    }

    @Override
    public List<Employee> findAll() {
        return allEmployees;
    }

    @Override
    public Employee save(Employee e) {
        for (Employee employee:allEmployees) {
            if(e.getId().equals(employee.getId())){
                int index = allEmployees.indexOf(employee);
                allEmployees.get(index).setSalary(e.getSalary());
            }
        }
        allEmployees.add(e);
        return allEmployees.get(allEmployees.size()-1);
    }

}
