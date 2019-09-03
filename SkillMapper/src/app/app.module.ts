import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import{EmployeeService} from './employee.service';
import { HttpClientModule }    from '@angular/common/http';
import { AppRoutingModule } from './/app-routing.module';

import { EmployeeDetailsComponent } from './employee-details/employee-details.component';

import { MessagesComponent } from './messages/messages.component';




@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,   
    EmployeeDetailsComponent,   
  ],
  imports: [
    BrowserModule,
      FormsModule,
       HttpClientModule,
       AppRoutingModule
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})


export class AppModule { }
