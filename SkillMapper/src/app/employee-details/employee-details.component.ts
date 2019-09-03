import { Component, OnInit,Input } from '@angular/core';

import { ActivatedRoute } from '@angular/router';


import { Employee }from '../employee_model';
import { EmployeeService }  from '../employee.service';
import { Location } from '@angular/common';


@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {


@Input() employee: Employee;
 //employee: Employee[];
  //employee: Employee;
  constructor( private route: ActivatedRoute,private employeeserv : EmployeeService,private location: Location) { 

    
  }

  ngOnInit() {
   this.getAll();
  }
getAll(): void {
    const employeeid = +this.route.snapshot.paramMap.get('employeeid');
    this.employeeserv.getid(employeeid)
    .subscribe(employee => this.employee = employee);
  }


  goBack(): void {
    this.location.back();
  }

 save(): void {
    this.employeeserv.updateEmployee(this.employee)
      .subscribe(() => this.goBack());
  }
 /* getAll(): void {
    this.employeeserv.getAll()
      .subscribe(employee => this.employee = employee.slice(1, 5));
      
  }*/
}
