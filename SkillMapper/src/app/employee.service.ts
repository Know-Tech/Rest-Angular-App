import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {Employee} from './employee_model';
import {EMPLOYEES} from './employee_listconstant';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})


export class EmployeeService {


private baseURL ='http://localhost:8080/ProjectRestAPI/api/employee';  // URL to web api

//private strUrl='api/employee';

//get all list 
getAll(): Observable<Employee[]> {
  //return of(EMPLOYEES);
  return this.http.get<Employee[]>(this.baseURL)
  
}
/** POST: add a new employee to the server */
  addservice (employee: Employee): Observable<Employee> {//observable data services is an angular injectale server
    return this.http.post<Employee>(this.baseURL, employee, httpOptions);
    
  }
  deleteEmployee (employee: Employee | number): Observable<Employee> {
    
    const id = typeof employee === 'number' ? employee : employee.employeeid;
    const url = `${this.baseURL}/${id}`;

    return this.http.delete<Employee>(url, httpOptions)
  }
  updateEmployee (employee:Employee): Observable<any> {
    return this.http.put(this.baseURL,employee, httpOptions);
    
  }
   getid(employeeid: number): Observable<Employee> {
    const url = `${this.baseURL}/${employeeid}`;
    return this.http.get<Employee>(url);
  }
 
  constructor(private http: HttpClient) { }
}
