package com.dao;

import org.hibernate.Session;

import com.bean.EmployeeBean;
public interface IEmployeeDAO {
	public void saveEmployee(Session session, EmployeeBean emp);
	public void getEmployee(Session session, String username, String password);		
	public void updateEmployee(EmployeeBean emp, Session session);
	public void changePassword(Session session, String username, String password);
}
