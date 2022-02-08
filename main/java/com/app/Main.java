package com.app;

import com.employee.EmployeeMain;
import com.tms.util.Utility;

/**
 * @author ritu
 *
 *         jan, 2022
 */
public class Main {

	public static void main(String[] args) throws Exception {

		// taking input
		int x;
		// choose 1 for trainer
		// choose 2 for employee
		System.out.println("Select 1 for Trainer.");
		System.out.println("Select 2 for Employee.");

		x = Integer.parseInt(Utility.stringUtil());
		switch (x) {
		/*
		 * case 1: TrainerMain tr = new TrainerMain(); tr.hi(); break;
		 */
		case 2:
			EmployeeMain emp = new EmployeeMain();
			emp.employeeMain();
			break;
		default:
			System.out.println("Incorrect choice.");
		}

	}
}
