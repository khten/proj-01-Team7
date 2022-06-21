package com.revature.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {
	
	private static EmployeeDao edao;
	
	/**
	 * Dependency Injection via Constructor Injection
	 * 
	 * Constructor Injection is a sophisticated way of ensuring that the Employee
	 * @param edao
	 */
	public EmployeeService(EmployeeDao edao){
		this.edao = edao;
	}
	
	//servlet will pass the username and the password to this method
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Employee confirmLogin(String username, String password) {
		
		Optional<Employee> possibleEmp = edao.findAll().stream()
				                            .filter(e-> (e.getUsername().equals(username) && (e.getPassword()).equals(password))).findFirst();
				                        		
		return (possibleEmp.isPresent() ? possibleEmp.get() : null);
		//optimize and setup a custom exception
	}
	public List<Employee> getAll(){
		return edao.findAll();
	}
}
