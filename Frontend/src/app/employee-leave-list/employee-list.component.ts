import { Component, OnInit } from '@angular/core';
import { Leave } from '../models/leave.model';
import { LeaveserviceService } from '../service/leaveservice.service';
import { AuthenticateService } from '../service/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  leaves : Leave[] = [];

  constructor(private service : LeaveserviceService, private authenticateService : AuthenticateService, 
    private router : Router) { }

  ngOnInit() {
    this.service.getAllLeaves().subscribe(data => {
      this.leaves = data;
      console.log(this.leaves);
    });
  }

  logout(){
    this.authenticateService.logout();
    this.router.navigate(['login']);
  }

  home(){
    if(sessionStorage.getItem("usertype")=="Manager")
    this.router.navigate(['manager']);
    else
    this.router.navigate(['employee']);
  }

}
