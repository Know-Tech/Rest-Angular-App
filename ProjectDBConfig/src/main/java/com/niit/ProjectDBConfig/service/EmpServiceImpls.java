package com.niit.ProjectDBConfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ProjectDBConfig.dao.EmpDao;
import com.niit.ProjectDBConfig.modal.Employee;

@Service
public class EmpServiceImpls implements EmpService {

	@Autowired
	private EmpDao employeedao;

	public boolean addservice(Employee emp) {

		return (employeedao.addEmployee(emp));

	}

	public boolean deleteService(int employeeid) {

		return (employeedao.deleteEmployee(employeeid));

	}

	public boolean updateEmployee(Employee employeeid) {

		return (employeedao.updateEmployee(employeeid));

	}

	public Employee getUpdateId(int employeeid) {
		return (employeedao.getUpdateId(employeeid));

	}

	public List<Employee> getAll() {

		return (employeedao.getAll());

	}

	public Employee getEmployeebyId(int employeeid) {
		return (employeedao.getEmployeebyId(employeeid));
	}

}
