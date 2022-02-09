package com.tms.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tms.beans.EmployeeBean;
import com.tms.employee.EmployeeDashboard;
import com.tms.employee.EmployeeMain;

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
		query.select(root).where(criteriaBuilder.equal(root.get("empUsername"), username),
				criteriaBuilder.equal(root.get("empPassword"), password));

		Query<EmployeeBean> employeeQuery = session.createQuery(query);
		EmployeeBean emp = employeeQuery.getSingleResult();
		dashboard.dashBoard(emp);

	}

	public void updateEmployee(EmployeeBean emp, Session session) {
		session.merge(emp);
		session.getTransaction().commit();
		System.out.println("Mobile Number and Company Name updated successfully!");
		EmployeeDashboard dashboard = new EmployeeDashboard();
		dashboard.dashBoard(emp);

	}

	public void changePassword(Session session, String username, String password) {
		EmployeeMain employeeMain = new EmployeeMain();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaUpdate<EmployeeBean> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(EmployeeBean.class);
		Root<EmployeeBean> root = criteriaUpdate.from(EmployeeBean.class);
		criteriaUpdate.set("empPassword", password);
		criteriaUpdate.where(criteriaBuilder.equal(root.get("empUsername"), username));
		session.createQuery(criteriaUpdate).executeUpdate();
		session.getTransaction().commit();
		System.out.println("Password Updated!");
		try {
			employeeMain.employeeMain();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
