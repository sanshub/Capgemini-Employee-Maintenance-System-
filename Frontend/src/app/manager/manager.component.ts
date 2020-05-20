import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../service/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  constructor(private router : Router, private authenticateService : AuthenticateService) { }

  ngOnInit() {
  }

  logout(){
    this.authenticateService.logout();
    this.router.navigate(['login']);
  }

  home(){
    this.router.navigate(['manager']);
  }

}
