package com.employee;

import static com.tms.util.HibernateUtil.getSessionFactory;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.EmployeeBean;
import com.tms.dao.EmployeeDAO;
import com.tms.util.Utility;

public class EmpProfile {
//	Session session = getSessionFactory().openSession();
//	Transaction transaction = session.beginTransaction();

	public void viewProfile(EmployeeBean emp) {

		System.out.println("Employee Name :" + emp.getEmpName());
		System.out.println("Employee Email :" + emp.getEmpEmail());
		System.out.println("Employee Contact Number :" + emp.getEmpMb());
		System.out.println("Employee Company Name :" + emp.getEmpCompanyName());

		System.out.println("Press 1 to Go Back.");
		System.out.println("Press 2 to Exit.");

		try {
			int ch = Integer.parseInt(Utility.stringUtil());

			switch (ch) {

			case 1:
				EmployeeDashboard dashboard = new EmployeeDashboard();
				dashboard.dashBoard(emp);
				break;
			case 2:
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

	public void editProfile(EmployeeBean emp) {
		EmployeeDAO dao = new EmployeeDAO();

		try {
			System.out.println("Employee Contact Number::" + emp.getEmpMb());

			System.out.println("Enter new Company Name::");
			String mb = Utility.stringUtil();
			emp.setEmpMb(mb);

			System.out.println("Employee Company Name :" + emp.getEmpCompanyName());
			System.out.println("Enter new Company name::");
			String company = Utility.stringUtil();
			emp.setEmpCompanyName(company);

//			dao.updateEmployee(emp, session);
//			session.close();

		}

		catch (IOException e) {
			System.out.println("Trainer Updation failed" + e);
		}

	}

	private Object getSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}
}
