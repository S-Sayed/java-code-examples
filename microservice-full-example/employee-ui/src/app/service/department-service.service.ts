import { Injectable } from '@angular/core';
import { Department } from '../model/department.model';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  constructor() { }

  loadDepartments(): Department[] {
    // sample data
    // TODO: it should call the API to load them from the department micro service

    return [
      new Department(1, "Developemnt"),
      new Department(2, "Network"),
      new Department(3, "DB")];
  }
}
