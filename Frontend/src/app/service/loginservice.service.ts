import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  base_url = "http://localhost:9500/sprintems/login";

  constructor(private _http:HttpClient) { }
  
  public loginUserFromRemote(user:User):Observable<any>{
  return this._http.post<any>(this.base_url,user)
  }
}
