import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/employee.model';
import { EmployeeSearchServiceService } from '../service/employee-search-service.service';
import { Router } from '@angular/router';
import { AuthenticateService } from '../service/authenticate.service';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css']
})
export class SearchEmployeeComponent implements OnInit {

  // movies: Movie[];
  employees : Employee[];
  genre:String;
  searchField:String;
  id:number;
 constructor(private employeeSearch : EmployeeSearchServiceService,private router : Router,
   private authenticateService : AuthenticateService) {
}

  onSubmit(){
    console.log(this.genre);
    if(this.genre=="all"){
      this.id=0;
      this.employeeSearch.fetchAllEmployees().subscribe(response=>{
        this.employees = response;
      })
    }
    else
      this.employeeSearch.fetchEmployees(this.genre,this.searchField).subscribe(data => {
        this.employees=data;
      });
    }
  
  ngOnInit() { }

  home(){
    this.router.navigate(['admin']);
  }

  logout(){
    this.authenticateService.logout();
    this.router.navigate(['login']);
  }

}
