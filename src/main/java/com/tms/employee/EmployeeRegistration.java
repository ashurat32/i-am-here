
/**
 * 
 */
package com.tms.employee;

import static com.tms.util.HibernateUtil.getSessionFactory;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tms.beans.EmployeeBean;
import com.tms.dao.EmployeeDAO;
import com.tms.util.Utility;
/**
 * @author ritu
 * @see employee registration jan, 2022
 */
public class EmployeeRegistration {

	public void register() throws Exception {

		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		EmployeeDAO dao = new EmployeeDAO();
		EmployeeBean empObj = new EmployeeBean();
		EmployeeMain emp = new EmployeeMain();
		try {
			System.out.println("Enter ID::");
			int empId = Utility.integerUtil();
			empObj.setEmpId(empId);

			System.out.println("Enter Name::");
			String empName = Utility.stringUtil();
			empObj.setEmpName(empName);

			System.out.println("Enter Email::");
			String empEmail = Utility.stringUtil();
			if (empEmail.contains(".com")) {
				System.out.println("Email is valid.");
				empObj.setEmpEmail(empEmail);
			} else {
				System.out.println("Email invalid. Please retry!");
				register();
			}

			System.out.println("Enter Company Name::");
			String empCompanyName = Utility.stringUtil();
			empObj.setEmpCompanyName(empCompanyName);
			
			System.out.println("Enter Mobile Number::");
			String empMb = Utility.stringUtil();
			empObj.setEmpMb(empMb);

			System.out.println("Enter your username :: ");
			String empUsername = Utility.stringUtil();
			empObj.setEmpUsername(empUsername);

			System.out.println("Enter your password :: ");
			String empPassword = Utility.stringUtil();
			System.out.print("Re Enter your password : ");
			String empPassword2 = Utility.stringUtil();
			if (empPassword.equals(empPassword2)) {
				System.out.println("Passwords match!");
				empObj.setEmpPassword(empPassword);
			} else {
				System.out.println("Passwords do not match, retry!");
				register();
			}
			
			dao.saveEmployee(session, empObj);
			emp.employeeMain();
			session.close();
		} catch (IOException e) {
			System.out.println("Employee Registration failed." + e);
		}
	}

}
