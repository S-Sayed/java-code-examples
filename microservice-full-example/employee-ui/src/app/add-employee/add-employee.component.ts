import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../service/employee-service.service';
import { Department } from '../model/department.model';
import { DepartmentService } from '../service/department-service.service';

@Component({
  selector: 'add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  formGroup: FormGroup;
  submitted: boolean;
  departments: Department[] = [];

  constructor(private formBuilder: FormBuilder, private router: Router, private employeeService: EmployeeService, private departmentService: DepartmentService) { }

  ngOnInit() {
    this.initFormGroup();
    this.departments =  this.departmentService.loadDepartments();
  }

  initFormGroup() {
    this.formGroup = this.formBuilder.group(
      {
        name: ['', Validators.required],
        department: ['', Validators.required]
      }
    )
  }

  addEmployee(): void {
    this.submitted = true;
    if (this.formGroup.invalid) {
      return;
    }

    console.log('Add Employee Form Data: ' , JSON.stringify(this.formGroup.value));

    this.employeeService.addEmployee(this.formGroup.value).subscribe(
      data => {
        console.log('data returned from addEmployee: ', data);
        this.router.navigate(['list-employees']);
      }
    );
  }
}