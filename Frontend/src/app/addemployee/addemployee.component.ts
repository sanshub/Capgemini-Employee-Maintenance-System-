import { Component, OnInit } from '@angular/core';
import { EmployeeserviceService } from '../service/employeeservice.service';
import { Employee } from '../models/employee.model';
import { EmployeeSearchServiceService } from '../service/employee-search-service.service';
import { AuthenticateService } from '../service/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {

  emp : Employee;
  // employees : Employee[];

  constructor(private service : EmployeeserviceService,private searchService : EmployeeSearchServiceService,
    private authenticateService : AuthenticateService, private router : Router) {
    this.emp = new Employee();
    // this.employees = [];
    // this.getEmployees();
   }

  ngOnInit() {
  }

  // getEmployees(){
  //   this.searchService.fetchAllEmployees().subscribe(response=>{
  //     this.employees = response;
  //   });
  //   console.log(this.employees);
  // }

  saveEmployee(){
    this.service.addEmp(this.emp);
    console.log(this.emp);
    this.emp = new Employee();
    
  }

  logout(){
    this.authenticateService.logout();
    this.router.navigate(['login']);
  }

  home(){
    this.router.navigate(['admin']);
  }

}
