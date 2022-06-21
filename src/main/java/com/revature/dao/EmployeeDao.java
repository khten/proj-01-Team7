package com.revature.dao;

import org.hibernate.Session;

import com.revature.models.Employee;

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
		
		
		//begin tx
		Transaction tx = ses.beginTransaction();
			
		//capture pk when session save() is called
		int pk = (int) ses.save(e);
		//return the pk
		return pk;
	}
	
	//Read all
	public List<Employee> findAll(){
		
	}
	
	public boolean delete() {
		return false;
	}
	
	public boolean update(Employee e) {
		return false;
	}
}
