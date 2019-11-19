import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../service/employee-service.service';
import { Department } from '../model/department.model';
import { DepartmentService } from '../service/department-service.service';

@Component({
  selector: 'edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  formGroup: FormGroup;
  submitted: boolean;
  departments: Department[] = [];

  constructor(private formBuilder: FormBuilder, private router: Router, private employeeService: EmployeeService, private departmentService: DepartmentService) { }

  ngOnInit() {
    console.log("edit-employee - ngOnInit");

    var selectedEmployee = JSON.parse(localStorage.getItem('selectedEmployee'));
    console.log('selectedEmployee: ', selectedEmployee);
    
    this.formGroup = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      department: [{}, Validators.required]
    })

    this.formGroup.setValue(selectedEmployee);
    this.departments = this.departmentService.loadDepartments();
  }

  selectOptionsCompare(val1, val2) {
    return val1.id === val2.id;
  }

  editEmployee(): void {
    this.submitted = true;

    if (this.formGroup.invalid) {
      return;
    }

    this.employeeService.editEmployee(this.formGroup.value).subscribe(
      data => {
        console.log('data returned from editEmployee: ', data);
        this.router.navigate(['list-employees']);
      }
    );
  }
}