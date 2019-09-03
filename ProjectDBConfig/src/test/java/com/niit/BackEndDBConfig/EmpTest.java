package com.niit.BackEndDBConfig;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.ProjectDBConfig.config.DBConfig;
import com.niit.ProjectDBConfig.modal.Employee;
import com.niit.ProjectDBConfig.service.EmpService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=DBConfig.class) 
public class EmpTest {

	@Autowired
	private EmpService empServices;
	
	private Employee emp;
	
	@Before
	public void setUp() throws Exception {
		
		emp=new Employee();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	/*@Test(expected=Exception.class)*/
	 @Test
	public void AddEmployee()
	{
	  	
		emp.setEmployeeid(112);
	  	emp.setEmployeename("mano");
	  	emp.setEmail("manos@gmail.com");
	  	emp.setPass("mano");
	  	emp.setAge(30);
	  	emp.setMobile("998745621");
	  	emp.setGender("male");
	  	emp.setQualification("be-cse");
		
	  //	assertEquals("Success",true,empServices.addservice(emp));
	  	assertEquals("Success",true,empServices.addservice(emp));
	}

}
