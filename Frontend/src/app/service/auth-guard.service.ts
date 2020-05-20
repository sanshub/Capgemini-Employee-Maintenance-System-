import { Injectable } from '@angular/core';
import { CanActivate,ActivatedRouteSnapshot,RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticateService } from './authenticate.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardAdminService implements CanActivate{

  constructor(public auth : AuthenticateService, public router : Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    // to check if user is logged in
    // if logged in then only allow the access over secured URL
    // or redirect to login component
    if(this.auth.isUserLoggedIn())
     { if(this.auth.typeOfUser() == "Admin")
      {
        
       if(route.url.toString() == "admin")
          return true;
      }else{
        this.router.navigate(['/login']);
        return false;
      }
    }
    else{
      this.router.navigate(['/login']);
      return false;
    }  
  }
}
