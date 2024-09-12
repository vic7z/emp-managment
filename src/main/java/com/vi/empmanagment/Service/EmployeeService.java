package com.vi.empmanagment.Service;

import com.vi.empmanagment.Model.Employee;
import com.vi.empmanagment.Repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employees;
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
        employees=new ArrayList<>();
        employees.add(new Employee(123,"aaa","engineer"));
        employees.add(new Employee(1234,"bbb","engineer"));
        employees.add(new Employee(125,"ccc","engineer"));
        employeeRepo.saveAll(employees);
    }

    public Boolean addEmployee(Employee employee) {
       if(this.employeeRepo.existsById(employee.getEmpId())){
           return false;
       }else {
           this.employeeRepo.save(employee);
           return true;
       }
//        Optional<Employee> emp = employees.stream()
//                .filter(i -> i.getEmpId() == employee.getEmpId())
//                .findFirst();
//        if (emp.isPresent()) {
//            return false;
//        }else {
//            return employees.add(employee);
//        }
    }

    public Boolean updateEmployee(Employee employee) {
      if (this.employeeRepo.existsById(employee.getEmpId())) {
          this.employeeRepo.save(employee);
          return true;
      }else {
          return false;
      }
//        Optional<Employee> emp = employees.stream()
//                .filter(i -> i.getEmpId() == employee.getEmpId())
//                .findFirst();
//        if (emp.isPresent()) {
//            employees.remove(emp.get());
//            employees.add(employee);
//            return true;
//        }
//        return false;
    }

    public void deleteEmployee(Employee employee) {
         this.employeeRepo.delete(employee);
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepo.findAll();
    }
    public Employee getEmployeeById(int id) {
//        return employees.stream().filter(i -> i.getEmpId() == id).findFirst().orElse(new Employee());
        return this.employeeRepo.getReferenceById(id);
    }

}
