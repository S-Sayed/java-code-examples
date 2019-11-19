import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Employee } from '../model/employee.model';
import { of, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
private baseURL = "http://localhost:8762/api";
  constructor(private http : HttpClient) { }

  getEmployees(){
    return this.http.get<Employee[]>(this.baseURL + '/employee-service/employees', 
    {observe: 'response'}) // to get full http response
    ;
  }

  deleteEmployee(id: number){
    return this.http.delete(this.baseURL + '/employee-service/employees/' + id, {observe: 'response'});
  }

  addEmployee(e: Employee){
   return this.http.post(this.baseURL + '/employee-service/employees', e);
  }

  editEmployee(e: Employee){
    return this.http.put(this.baseURL + '/employee-service/employees', e);
  }
}