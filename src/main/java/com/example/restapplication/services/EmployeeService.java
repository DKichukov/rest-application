package com.example.restapplication.services;

import com.example.restapplication.exceptions.EmployeeNotFoundException;
import com.example.restapplication.models.Employee;
import com.example.restapplication.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee empl) {
        return employeeRepository.save(empl);
    }

    public List<Employee> addEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> readEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> readEmployee(Integer id) {
        if (employeeRepository.findById(id).isPresent())
            return employeeRepository.findById(id);
        else throw new EmployeeNotFoundException();
    }

    public Optional<List<Employee>> readEmployeesByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    public Employee editEmployee(Employee empl, Integer id) {
        if (employeeRepository.findById(id).isPresent()) {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(empl.getName());
            employee.setAge(empl.getAge());
            employee.setSalary(empl.getSalary());
            employee.setGender(empl.getGender());
            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    public Boolean deleteEmployees(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }else throw new EmployeeNotFoundException();
    }
}
