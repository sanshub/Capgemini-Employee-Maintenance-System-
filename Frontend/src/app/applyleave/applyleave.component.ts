import { Component, OnInit } from '@angular/core';
import { Leave } from '../models/leave.model';
import { LeaveserviceService } from '../service/leaveservice.service';
import { Router } from '@angular/router';
import { AuthenticateService } from '../service/authenticate.service';

@Component({
  selector: 'app-applyleave',
  templateUrl: './applyleave.component.html',
  styleUrls: ['./applyleave.component.css']
})
export class ApplyleaveComponent implements OnInit {

  startDate : Date;
  endDate : Date;

  leave : Leave;

  constructor(private service  : LeaveserviceService, private route : Router,
    private authenticateService : AuthenticateService) {
    this.leave = new Leave();

   }

  ngOnInit() {
  }

  applyLeave(){
    this.leave.startDate = this.startDate;
    this.leave.endDate = this.endDate;
    console.log(this.leave.startDate);
    console.log(this.leave.endDate);
    this.service.applyLeave(this.leave.startDate,this.leave.endDate).subscribe(response => {
      this.route.navigate(['employee']);
    });
  }

  logout(){
    this.authenticateService.logout();
    this.route.navigate(['login']);
  }

  home(){
    if(sessionStorage.getItem("usertype")=="Manager")
    this.route.navigate(['manager']);
    else
    this.route.navigate(['employee']);
  }

}
