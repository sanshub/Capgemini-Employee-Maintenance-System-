import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../service/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit {

  constructor(private authenticateService : AuthenticateService, private router : Router) { }

  ngOnInit() {
  }

  logout(){
    this.authenticateService.logout();
    this.router.navigate(['login']);
  }

  home(){
    this.router.navigate(['admin']);
  }

}
