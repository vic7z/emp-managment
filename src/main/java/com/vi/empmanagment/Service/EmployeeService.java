package com.vi.empmanagment.Service;

import com.vi.empmanagment.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    List<Employee> employees;

    public EmployeeService() {
        employees=new ArrayList<>();
        employees.add(new Employee(123,"aaa","engineer"));
        employees.add(new Employee(1234,"bbb","engineer"));
        employees.add(new Employee(125,"ccc","engineer"));
    }

    public Boolean addEmployee(Employee employee) {
        Optional<Employee> emp = employees.stream()
                .filter(i -> i.getEmpId() == employee.getEmpId())
                .findFirst();
        if (emp.isPresent()) {
            return false;
        }else {
            return employees.add(employee);
        }
    }

    public Boolean updateEmployee(Employee employee) {
        Optional<Employee> emp = employees.stream()
                .filter(i -> i.getEmpId() == employee.getEmpId())
                .findFirst();
        if (emp.isPresent()) {
            employees.remove(emp.get());
            employees.add(employee);
            return true;
        }
        return false;
    }

    public Boolean deleteEmployee(Employee employee) {
        return employees.remove(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
    public Employee getEmployeeById(int id) {
        return employees.stream().filter(i -> i.getEmpId() == id).findFirst().orElse(new Employee());
    }

}
