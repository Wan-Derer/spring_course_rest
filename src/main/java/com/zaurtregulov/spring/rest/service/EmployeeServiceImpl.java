package com.zaurtregulov.spring.rest.service;

import com.zaurtregulov.spring.rest.dao.EmployeeDAO;
import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

  @Autowired
  private EmployeeDAO employeeDAO;

  @Override
  @Transactional
  public List<Employee> getAllEmployees() {
    return employeeDAO.getAllEmployees();
  }

  @Override
  @Transactional
  public void saveEmployee(Employee employee) {
    employeeDAO.saveEmployee(employee);
  }

  @Transactional
  @Override
  public Employee getEmployeeById(int id) {
    return employeeDAO.getEmployeeById(id);
  }

  @Transactional
  @Override
  public void deleteEmployee(int id) {
    employeeDAO.deleteEmployee(id);
  }
}
