import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { EmployeeComponent } from './employee/employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';



const routes: Routes = [
  { path: 'employeedetails', component: EmployeeDetailsComponent },
  { path: 'employee', component: EmployeeComponent },
  { path: 'detail/:employeeid', component: EmployeeDetailsComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
