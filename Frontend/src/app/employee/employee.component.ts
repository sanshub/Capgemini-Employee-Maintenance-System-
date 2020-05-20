import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticateService } from '../service/authenticate.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private router : Router, private authenticateService : AuthenticateService) { }

  ngOnInit() {
  }

  logout(){
    this.authenticateService.logout();
    this.router.navigate(['login']);
  }

  callSearch(){
    this.router.navigate(['employee/search']);
  }

}
