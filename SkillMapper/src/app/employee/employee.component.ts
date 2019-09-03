import { Component, OnInit } from '@angular/core';
import{Employee} from '../employee_model';
import{EMPLOYEES} from '../employee_listconstant';
import{EmployeeService} from '../employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {


  emp: Employee;

  empl:Employee[];

  constructor(private employeeserv:EmployeeService) { }

  ngOnInit() {
    this.getAll();
  }

getAll(): void {
  this.employeeserv.getAll().subscribe(empl => this.empl = empl);
}

add(employeeid:number,employeename:string,email:string,pass:string,age:number,mobile:string,gender:string,qualification:string): void {
 
   this.emp=new Employee();
   if(employeeid!=0)
   {
  this.emp.employeeid=employeeid;
  this.emp.employeename=employeename;
  this.emp.email=email;
  this.emp.pass=pass;
  this.emp.age=age;
  this.emp.mobile=mobile;
  this.emp.gender=gender;
  this.emp.qualification=qualification;


  
    this.employeeserv.addservice(this.emp)
      .subscribe(employee => {
        this.empl.push(this.emp);
      });
   }
  }
 
   delete(employee:Employee): void {

  this.empl = this.empl.filter(h => h !== employee);
    this.employeeserv.deleteEmployee(employee).subscribe();
}

/*onSelect(employee: Employee): void {
  this.selectedEmployee = employee;
}*/
}
