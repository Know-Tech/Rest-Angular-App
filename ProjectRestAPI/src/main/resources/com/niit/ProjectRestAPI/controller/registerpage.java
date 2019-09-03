package com.niit.ProjectRestAPI.controller;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.niit.ProjectRestAPI.model.Employee;
import com.niit.ProjectRestAPI.service.EmployeeService;

@Controller
public class registerpage {

	
	@Autowired
	private EmployeeService serveobj; 
	
	
	private Employee employees;//model
	
	@GetMapping("/")
	public String addEmployee(Model model) 
	{
		model.addAttribute("employees",new Employee());
		model.addAttribute("list",serveobj.getAll());
		return "employee";//viewpage
	}
	@PostMapping("/employee/add")//view page mapping
	public String addEmployee1(@ModelAttribute("employees")Employee employees)//model
	 {
		
			if(employees.getEmployeeid()!=0) 
			{
			serveobj.addservice(employees);	
			}
			
		return "redirect:/"; //  to redirect to root element which calls mapped
		}
	@GetMapping("/remove/{employeeid}")
	public String removeEmloyee(@PathVariable("employeeid") int employeeid)
	{
		
		serveobj.deleteService(employeeid);
        return "redirect:/";
   }
	@PostMapping("/employee/modify") 
	public String modifyEmployee(@ModelAttribute("employees") Employee employees)// model
	{

		if (employees.getEmployeeid() != 0) {
			serveobj.updateEmployee(employees);
		}

		return "redirect:/"; // to redirect to root element 
	}
	@GetMapping("/edit/{employeeid}")
	public String editEmployee(@PathVariable("employeeid") int id, Model model) {
		model.addAttribute("employees", serveobj.getEmployeebyId(id));
		//model.addAttribute("employees", serveobj.getAll());
		return "employeeList";
	}
	
	@GetMapping("/view/{employeeid}") 
	public String viewEmployee(@PathVariable("employeeid")int id,Model model) {
		 model.addAttribute("employees", serveobj.getEmployeebyId(id));
		//model.addAttribute("employees", serveobj.getAll());
		return "viewList";
	}
	
	@PostMapping("/view/display") 
	public String viewdisplay(@ModelAttribute("employees")Model model)// model
	{

		
		model.addAttribute("list",serveobj.getAll());
		System.out.println("***");

		return "redirect:/"; // to redirect to root element 
	}
   


}