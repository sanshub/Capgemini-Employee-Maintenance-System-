import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { Routes, RouterModule } from "@angular/router";
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { EmployeeComponent } from './employee/employee.component';
import { AuthGuardAdminService } from './service/auth-guard.service';
import { AuthGuardEmployeeService } from './service/auth-gaurd-employee.service';
import { ManagerComponent } from './manager/manager.component';
import { AuthGuardManagerService } from './service/auth-guard-manager.service';
import { EmployeeListComponent } from './employee-leave-list/employee-list.component';
import { ApplyleaveComponent } from './applyleave/applyleave.component';
import { ManagerLeaveListComponent } from './manager-leave-list/manager-leave-list.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import { SearchEmployeeComponent } from './search-employee/search-employee.component';

const routes: Routes = [
  { path:'',redirectTo: '/login', pathMatch: 'full'},
    { path:'login',component:LoginComponent},
    { path:'admin',component:LoginsuccessComponent ,canActivate : [AuthGuardAdminService]} ,
    { path:'employee',component:EmployeeComponent ,canActivate : [AuthGuardEmployeeService]},
    { path:'manager',component:ManagerComponent ,canActivate : [AuthGuardManagerService]},
    { path:'manager/managerleavelist',component:ManagerLeaveListComponent},
    { path:'employee/employeeleavelist',component:EmployeeListComponent},
    { path:'employee/applyleave',component:ApplyleaveComponent},
    { path:'manager/employeeleavelist',component:EmployeeListComponent},
    { path:'manager/applyleave',component:ApplyleaveComponent},
    { path:'admin/add',component:AddemployeeComponent},
    { path:'admin/employeeleavelist',component:EmployeeListComponent},
    { path:'manager/managerleavelist/managerleavelist',component:ManagerLeaveListComponent},
    { path:'employee/search',component:SearchEmployeeComponent},
    { path:'admin/search',component:SearchEmployeeComponent}


];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoginsuccessComponent,
    EmployeeComponent,
    ManagerComponent,
    EmployeeListComponent,
    ApplyleaveComponent,
    ManagerLeaveListComponent,
    AddemployeeComponent,
    SearchEmployeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
