package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;

//servlet->service->service->
public class EmployeeDao {

	//CRUD Methods
	
	/**
	 * Insert an employee into the db.  We'll have a register() method
	 * @param e
	 * @return
	 */
	//create
	public int insert(Employee e) {
		Session ses = HibernateUtil.getSession();
		//grab session obj
		
		
		//begin tx  //pull from hibernate
		Transaction tx = ses.beginTransaction();
			
		//capture pk when session save() is called
		int pk = (Integer) ses.save(e);
		//return the pk
		return pk;
	}
	
	//Read all
	public List<Employee> findAll(){
		Session session = HibernateUtil.getSession();
		//make an HQL statment   (Hibernate Query Language:  odd mix of oop and native sql
		List<Employee> emps = ses.createQuery("from Employee", Employee.class).list();
		return emps;
	}
	
	public boolean delete() {
		return false;
	}
	
	public boolean update(Employee e) {
		return false;
	}
}
