package com.employee;

import static com.tms.util.HibernateUtil.getSessionFactory;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.EmployeeBean;
import com.tms.dao.EmployeeDAO;
import com.tms.util.Utility;

/**
 * @author ritu
 * @see employee registration jan, 2022
 */
public class EmployeeRegistration {

	public static void register() throws NumberFormatException, IOException {

		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		//session.beginTransaction();

		EmployeeDAO dao = new EmployeeDAO();
		EmployeeBean empObj = new EmployeeBean();

		
		System.out.println("Enter Name::");
		String empName = Utility.stringUtil();
		empObj.setEmpName(empName);
		
		System.out.println("Enter Mobile Number::");
		String empMb = Utility.stringUtil();
		empObj.setEmpMb(empMb);
		
		System.out.println("Enter Company Name::");
		String empCompanyName = Utility.stringUtil();
		empObj.setEmpCompanyName(empCompanyName);

		System.out.println("Enter Email::");
		String empEmail = Utility.stringUtil();
//		if (empEmail.contains(".com")) {
//			System.out.println("Email is valid.");
			empObj.setEmpEmail(empEmail);
//		} else {
//			System.out.println("Email invalid. Please retry!");
//			register();
//		}

		System.out.println("Enter your username :: ");
		String empUsername = Utility.stringUtil();
		empObj.setUsername(empUsername.trim());
		
		System.out.println("Enter your password :: ");
		String empPassword = Utility.stringUtil();
		System.out.print("Re Enter your password : ");
		String empPassword2 = Utility.stringUtil();
		if (empPassword.equals(empPassword2)) {
			System.out.println("Passwords match!");
			empObj.setPassword(empPassword);
		} else {
			System.out.println("Passwords do not match, retry!");
			//register();
		}
		System.out.println("Login Successful!");
		dao.saveEmployee(session, empObj);
		//session.close();
	}

}
