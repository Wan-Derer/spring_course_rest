package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/ok")
  public String printOk(){

    return ">>>>>>>>>>> OK";

  }

  @GetMapping("/employees")
  public List<Employee> showAllEmployees(){

    List<Employee> allEployees = employeeService.getAllEmployees();

    return allEployees;

  }


}
