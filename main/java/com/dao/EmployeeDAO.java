package com.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.bean.EmployeeBean;
import com.employee.EmployeeDashboard;
import com.tms.beans.Trainer;
import com.tms.trainer.TrainerDashboard;

public class EmployeeDAO implements IEmployeeDAO {

	public void saveEmployee(Session session, EmployeeBean emp) {
		session.save(emp);
		session.getTransaction().commit();
		System.out.println("Congratulations! You have been registered.");

	}

	public void getEmployee(Session session, String username, String password) {
		EmployeeDashboard dashboard = new EmployeeDashboard();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<EmployeeBean> query = criteriaBuilder.createQuery(EmployeeBean.class);
		Root<EmployeeBean> root = query.from(EmployeeBean.class);
		query.select(root).where(criteriaBuilder.equal(root.get("username"), username),
				criteriaBuilder.equal(root.get("password"), password));

		Query<EmployeeBean> employeeQuery = session.createQuery(query);
		EmployeeBean bean = employeeQuery.getSingleResult();
		//dashboard.dashBoard(bean);
		System.out.println("Success");
	}

	public void updateEmployee(EmployeeBean emp, Session session) {
		session.merge(emp);
		session.getTransaction().commit();
		System.out.println("Mobile Number and Company Name updated successfully!");

	}

	public void changePassword(Session session, String username, String password) {
		String query = "update employee set password = " + password + " where username = " + username;
		try {
			session.createSQLQuery(query).executeUpdate();
			session.getTransaction().commit();
			System.out.println("Password Updated!");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}

	}

}
