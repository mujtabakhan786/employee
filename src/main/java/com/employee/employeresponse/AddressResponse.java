package com.employee.employeresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

	private int id;
	private String lane1;
	private String lane2;
	private String state;
	private String zip;
}
