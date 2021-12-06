package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class MyController {

  final private EmployeeService employeeService;

  @GetMapping("/ok")
  public String printOk() {

    return ">>>>>>>>>>> OK";
  }

  @GetMapping("/employees")
  public List<Employee> showAllEmployees() {

    List<Employee> allEployees = employeeService.getAllEmployees();

    return allEployees;
  }

  @GetMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable int id) {

    Employee emp = employeeService.getEmployeeById(id);

    if (emp == null) throw new NoSuchEmployeeException("Нет сотрудника с ID = " + id);

    return emp;
  }

  @PostMapping("/employees")
  public Employee addNewEmployee(@RequestBody Employee employee){

    employeeService.saveEmployee(employee);

    return employee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee){

    employeeService.saveEmployee(employee);

    return employee;
  }

  @DeleteMapping(value = "/employees/{id}", produces = "text/html; charset=utf-8")
  public String deleteEmployee(@PathVariable int id) {

    String name = employeeService.getEmployeeById(id).getSurname();

    employeeService.deleteEmployee(id);

    return "Сотрудник " + name + " погорел";
  }




}
