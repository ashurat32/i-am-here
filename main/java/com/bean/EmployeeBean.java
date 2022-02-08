package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ritu
 * @see bean class for employee jan, 2022
 */
@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
public class EmployeeBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	private String empEmail;
	private String empCompanyName;
	private String empMb;
	private String username;
	private String password;
	public EmployeeBean() {
		
	}

	

	
}
