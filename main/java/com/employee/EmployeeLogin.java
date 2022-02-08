package com.employee;

import java.io.IOException;
import static com.tms.util.HibernateUtil.getSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.tms.dao.EmployeeDAO;
import com.tms.util.Utility;


/**
 * @author ritu
 *
 *         jan, 2022
 */
public class EmployeeLogin {

	EmployeeDAO dao = new EmployeeDAO();

	Session session = getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();

	public void empLogin() throws IOException {

		System.out.println("Enter your username");
		String username = Utility.stringUtil();

		System.out.println("Enter your Password");
		String password = Utility.stringUtil();

		dao.getEmployee(session, username, password);
		//session.close();

	}

}
