package com.niit.ProjectDBConfig.dao;

import java.util.List;

import com.niit.ProjectDBConfig.modal.Employee;

public interface EmpDao {

	
	public boolean addEmployee(Employee emp);

	public boolean updateEmployee(Employee employeeid);

	public boolean deleteEmployee(int employeeid);

	public Employee getUpdateId(int employeeid);

	public Employee getEmployeebyId(int employeeid);

	public List<Employee> getAll();
}
