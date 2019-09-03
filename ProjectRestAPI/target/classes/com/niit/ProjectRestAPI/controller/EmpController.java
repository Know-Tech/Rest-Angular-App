package com.niit.ProjectRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ProjectDBConfig.model.Employee;
import com.niit.ProjectDBConfig.service.*;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins="http://localhost:4200")
public class EmpController {

	@Autowired
	 private EmpService empService;

	@PostMapping("add-Emp")	 
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
		
		empService.addservice(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("Emp-list")  
    public List<Employee> getAllEmp() {  
         return empService.getAll();            
    }  


	@GetMapping("/{employeeid}")
	public ResponseEntity<Employee> getEmployees(@PathVariable("employeeid") int employeeid) {
		if (empService.getEmployeebyId(employeeid) != null) {
			return new ResponseEntity<Employee>(serveobj.getEmployeebyId(employeeid), HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

		}
	}

	// @DeleteMapping("/delete/{employeeid}")
	// @GetMapping
	@DeleteMapping("/{employeeid}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeid") int employeeid) {
		if (empService.getEmployeebyId(employeeid) != null) {

			empService.deleteService(employeeid);

			return new ResponseEntity<Void>(HttpStatus.OK);

		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}
	}

	// @PostMapping("/adding")
	@PostMapping

	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {

		empService.addservice(employee);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// @PutMapping("update/{employeeid}")
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {

		if (empService.getEmployeebyId(employee.getEmployeeid()) != null) {
			empService.updateEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
