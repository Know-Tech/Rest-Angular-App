package com.niit.ProjectDBConfig.service;

import java.util.List;

import com.niit.ProjectDBConfig.modal.Employee;

public interface EmpService {

	public boolean addservice(Employee emp);

	public boolean deleteService(int employeeid);

	public boolean updateEmployee(Employee employeeid);

	public Employee getUpdateId(int employeeid);

	public Employee getEmployeebyId(int employeeid);

	public List<Employee> getAll();
}
