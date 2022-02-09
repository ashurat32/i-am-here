package com.tms.app;


import com.tms.employee.EmployeeMain;
import com.tms.trainer.TrainerPage;
import com.tms.util.Utility;

/**
 *
 * @author Ashish
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		TrainerPage tr = new TrainerPage();
		EmployeeMain emp = new EmployeeMain();

		System.out.println("----------Welcom---------");
		System.out.println("Select one Option.");
		System.out.println("Enter 1 for Trainer");
		System.out.println("Enter 2 for Employee");
		System.out.println("Enter 3 for exit");

		try {
			int choose = Integer.parseInt(Utility.stringUtil());

			switch (choose) {

			case 1:
				tr.trainer();
				break;
			case 2:
				emp.employeeMain();
				break;
			case 3:
				System.out.println("Exit");
				break;
			default:
				System.out.println("invalid choice");
				break;
			}

		} catch (Exception e) {
			System.out.println("Invalid input please choose valid input");


		}

	}

}
