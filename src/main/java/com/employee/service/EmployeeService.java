package com.employee.service;

import java.util.List;

import com.employee.employeresponse.EmployeeResponse;
import com.employee.entities.Employee;

public interface EmployeeService {
	
	
	public EmployeeResponse createemployee(Employee employee);
	
	public List<EmployeeResponse> getAllEmployee();
	
	public EmployeeResponse getEmployeeById(Integer id);
	
	public String deleteEmployees(Integer id);

}
