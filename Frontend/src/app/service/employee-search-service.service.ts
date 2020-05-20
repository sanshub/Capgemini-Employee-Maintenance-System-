import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../models/employee.model';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class EmployeeSearchServiceService {

  constructor(private http : HttpClient ) {}

  fetchEmployees(genre: String,searchValue: String): Observable<Employee[]> {
    return this.http.get<Employee[]>(`http://localhost:9200/employeesearch/search/${genre}/${searchValue}`);
  }

  fetchAllEmployees(){
    return this.http.get<Employee[]>("http://localhost:9200/employeesearch/search");
  }
}
