import { Component, OnInit } from '@angular/core';
import { NgForm } from "@angular/forms";

import { User } from '../models/user.model';
import { Router } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { LoginserviceService } from '../service/loginservice.service';
import { AuthenticateService } from '../service/authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    user=new User();
    userr=new User();
    rolee:string;
    msg='';
    constructor(private _service : LoginserviceService,private auth : AuthenticateService,private router: Router) { }

    ngOnInit() {
    }
 
    loginUser(){
      this._service.loginUserFromRemote(this.user).subscribe(
      data=>{
        console.log("response received");
       // this.router.navigate(['/loginsuccess'])
        this.userr=data;
        sessionStorage.setItem("loggedInUser",JSON.stringify(this.userr));
        // sessionStorage.setItem("loggedInUserEmail",this.userr.emailId);
        // sessionStorage.setItem("loggedInUserId",this.userr.id.toString);
       if( this.auth.authenticate(this.userr)){
          if(this.userr.role=="Admin")
        this.router.navigate(['/admin'])
        if(this.userr.role=="Employee")
        this.router.navigate(['/employee'])
        if(this.userr.role=="Manager")
        this.router.navigate(['/manager'])
        
        }
          else
          this.router.navigate(['/login'])

      
     },
      error=>{
        console.log("exception occured")
        this.msg="Bad Credentials! Please enter valid email Id/Password";
      
    })
  }
}
