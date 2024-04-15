package com.employee.employeresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

	private int id;
	private String name;
	private String email;
	private String bloodGroup;
	private AddressResponse addressResponse;
}
