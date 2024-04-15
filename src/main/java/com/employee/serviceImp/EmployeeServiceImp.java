package com.employee.serviceImp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

import com.employee.employeresponse.AddressResponse;
import com.employee.employeresponse.EmployeeResponse;
import com.employee.entities.Employee;
import com.employee.repo.EmployeeRepo;
import com.employee.service.EmployeeService;

import ch.qos.logback.core.model.Model;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;

	//@Autowired
	private RestTemplate restTemplate;
	
//	@Value("${addressservice.base.url}")
//	private String addressBaseURL; 
	
	
	
	public EmployeeServiceImp(@Value("${addressservice.base.url}") String addressBaseURL,RestTemplateBuilder builder) {
		this.restTemplate=  builder.rootUri(addressBaseURL).build();
	}

	@Override
	public EmployeeResponse createemployee(Employee employee) {
		Employee save = this.employeeRepo.save(employee);
		EmployeeResponse map = mapper.map(save, EmployeeResponse.class);
		return map;

	}

	@Override
	public List<EmployeeResponse> getAllEmployee() {

		List<Employee> all = this.employeeRepo.findAll();
		List<EmployeeResponse> map = mapper.map(all, new TypeToken<List<EmployeeResponse>>() {
		}.getType());
		return map;
	}

	@Override
	public EmployeeResponse getEmployeeById(Integer id) {
		Employee employee = this.employeeRepo.findById(id).orElseThrow();
		EmployeeResponse map = this.mapper.map(employee, EmployeeResponse.class);
		AddressResponse forObject = restTemplate.getForObject("/address/{id}", AddressResponse.class,id);
		map.setAddressResponse(forObject);
		return map;
	}

	@Override
	public String deleteEmployees(Integer id) {
		this.employeeRepo.deleteById(id);
		return "Delete Succesfully";

	}

}
