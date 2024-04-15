package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.employeresponse.AddressResponse;
import com.employee.employeresponse.EmployeeResponse;
import com.employee.entities.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee) {
		EmployeeResponse createemployee = this.employeeService.createemployee(employee);
		return ResponseEntity.ok(createemployee);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
		List<EmployeeResponse> allEmployee = this.employeeService.getAllEmployee();

		System.out.println("alllllllllllllll " + allEmployee.toString());
		return ResponseEntity.ok().body(allEmployee);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Integer id) {
		EmployeeResponse employeeById = this.employeeService.getEmployeeById(id);

		return ResponseEntity.ok().body(employeeById);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployees(@PathVariable Integer id) {
		this.employeeService.deleteEmployees(id);
		return "Delete Succesfully";

	}
}
