import { Component, OnInit } from '@angular/core';
import { Leave } from '../models/leave.model';
import { LeaveserviceService } from '../service/leaveservice.service';
import { User } from '../models/user.model';
import { Router } from '@angular/router';
import { AuthenticateService } from '../service/authenticate.service';

@Component({
  selector: 'app-manager-leave-list',
  templateUrl: './manager-leave-list.component.html',
  styleUrls: ['./manager-leave-list.component.css']
})
export class ManagerLeaveListComponent implements OnInit {

  leaves : Leave[] = [];
  userObj : User;

  constructor(private service : LeaveserviceService, private router: Router, 
    private authenticateService : AuthenticateService) { }

  ngOnInit() {
    this.service.getAllManagerLeaves().subscribe(data => {
      this.leaves = data;
      console.log(this.leaves);
    });
  }

  approve(index : number){
    console.log(index);
    this.service.approve(index);
  }

  reject(index:number){
    this.service.reject(index);
  }

  logout(){
    this.authenticateService.logout();
    this.router.navigate(['login']);
  }

  home(){
    this.router.navigate(['manager']);
  }

}
