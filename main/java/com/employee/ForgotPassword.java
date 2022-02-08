package com.employee;

import java.io.IOException;
import static com.tms.util.HibernateUtil.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tms.dao.EmployeeDAO;
import com.tms.util.Utility;


public class ForgotPassword {
	
	public void forgotPassword() throws IOException {

		EmployeeDAO dao = new EmployeeDAO();
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("---------Forgot Password---------");
		System.err.println("Enter your UserName..");
		String username = Utility.stringUtil();
		System.out.println("Create new Password");
		String password = Utility.stringUtil();

		dao.changePassword(session, username, password);

	}

}
