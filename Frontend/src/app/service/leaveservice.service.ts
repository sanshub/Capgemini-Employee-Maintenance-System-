import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Leave } from '../models/leave.model';
import { templateSourceUrl } from '@angular/compiler';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class LeaveserviceService {

  base_url = "http://localhost:9300/employeeleavelist/";
  manager_url = "http://localhost:9300/managerleavelist/";
  // manager_id="456789";
  apply_leave = "addleave/"
  tempUser = new User();

  constructor(private http : HttpClient) { 
    this.tempUser = JSON.parse(sessionStorage.getItem("loggedInUser"));
  }

  getAllLeaves(){
    return this.http.get<Leave[]>(this.base_url + this.tempUser.userId); 
  }

  getAllManagerLeaves(){
    return this.http.get<Leave[]>(this.manager_url+this.tempUser.userId);
  }

  applyLeave(startDate : Date, endDate : Date){
    console.log(startDate);
    console.log(endDate);
    // console.log(sessionStorage.getItem("loggedInUserEmail"));
    // console.log(this.tempUser.id);
    return this.http.post<any>("http://localhost:9300/addleave",{"startDate":startDate,
    "emailId":this.tempUser.emailId,"endDate":endDate});
  }

  approve(index:number){
      // leaveId : String;
      // let leaveId = index.toString;
      return this.http.get<any>(`http://localhost:9300/updateleave/approve/${index}`).subscribe();
  }

  reject(index:number){
     return this.http.get<any>(`http://localhost:9300/updateleave/reject/${index}`).subscribe();
  }
  
  }
