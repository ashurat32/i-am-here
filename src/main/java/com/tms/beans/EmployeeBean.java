package com.tms.beans;

import javax.persistence.Entity;
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
	private int empId;
	private String empName;
	private String empEmail;
	private String empCompanyName;
	private String empMb;
	private String empUsername;
	private String empPassword;

	public EmployeeBean() {

	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpCompanyName() {
		return empCompanyName;
	}

	public void setEmpCompanyName(String empCompanyName) {
		this.empCompanyName = empCompanyName;
	}

	public String getEmpMb() {
		return empMb;
	}

	public void setEmpMb(String empMb) {
		this.empMb = empMb;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empCompanyName="
				+ empCompanyName + ", empMb=" + empMb + ", empUsername=" + empUsername + ", empPassword=" + empPassword
				+ "]";
	}

}
