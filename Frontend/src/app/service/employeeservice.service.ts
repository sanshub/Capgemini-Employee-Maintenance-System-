import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../models/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeserviceService {

  constructor(private http : HttpClient) { 
    
  }

  addEmp(employee : Employee){
    return this.http.post<Employee>("http://localhost:9100/employees/addemployee",employee).subscribe();
   }
}
