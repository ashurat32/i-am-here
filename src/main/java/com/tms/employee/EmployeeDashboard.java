package com.tms.employee;

import java.io.IOException;

import com.tms.beans.EmployeeBean;
import com.tms.util.Utility;


public class EmployeeDashboard {
	
	public void dashBoard(EmployeeBean emp) {

		EmpProfile profile = new EmpProfile();
		System.out.println("Enter 1 to View Profile.");
		System.out.println("Enter 2 to Edit Profile.");
		System.out.println("Press 3 to Exit");

		try {
			int ch = Utility.integerUtil();

			switch (ch) {

			case 1:
				profile.viewProfile(emp);
				break;
			case 2:
				profile.editProfile(emp);
				break;
			case 3:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid choice.");
				break;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
