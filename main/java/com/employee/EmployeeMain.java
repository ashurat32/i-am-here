package com.employee;

import com.tms.util.Utility;

/**
 * @author ritu
 *
 *         jan, 2022
 */
public class EmployeeMain {

	public void employeeMain() throws Exception {

		System.out.println("\nEnter 1 to Login.");
		System.out.println("Enter 2 to Register.");
		System.out.println("Enter 3 to Change Password.");
		System.out.println("Enter 4 to Go Back.");

		ForgotPassword pass = new ForgotPassword();

		int a = Integer.parseInt(Utility.stringUtil());
		switch (a) {
		case 1:
			System.out.println("You are being redirected for login.");
			EmployeeLogin login = new EmployeeLogin();
			login.empLogin();
			break;

		case 2:
			//System.out.println("You are being redirected for new registeration.");
			
			EmployeeRegistration.register();
			break;

		case 3:
			System.out.println("You are being redirected for new password.");
			pass.forgotPassword();

			// case 4: Main.main(null);

		default:
			System.out.println("invalid selection");
			break;
		}

	}

}
