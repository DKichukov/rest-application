package com.example.restapplication.controllers;

import com.example.restapplication.models.Employee;
import com.example.restapplication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee empl) {
        return new ResponseEntity<>(employeeService.addEmployee(empl), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@RequestBody List<Employee> empls) {
        return new ResponseEntity<>(employeeService.addEmployees(empls), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        return new ResponseEntity<>(employeeService.readEmployees(), HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.readEmployee(id), HttpStatus.OK);
    }
    @GetMapping("/employeesByGender")
    public ResponseEntity<Object> getEmployeesByGender(@RequestParam String gender) {
        return new ResponseEntity<>(employeeService.readEmployeesByGender( gender), HttpStatus.OK);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee empl,@PathVariable Integer id){
        return new ResponseEntity<>(employeeService.editEmployee(empl,id), HttpStatus.OK);
    }
    @DeleteMapping("/employees")
    public ResponseEntity<Object>deleteEmployee(@RequestParam int id) {
        return new ResponseEntity<>(employeeService.deleteEmployees(id), HttpStatus.OK);
    }
}
