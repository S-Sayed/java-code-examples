import { Component, OnInit, ViewChild } from '@angular/core';
import { Employee } from '../model/employee.model';
import { EmployeeService } from '../service/employee-service.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { MatPaginator, MatTableDataSource, MatSort } from '@angular/material';

@Component({
  selector: 'list-employees',
  templateUrl: './list-employees.component.html',
  styleUrls: ['./list-employees.component.css']
})
export class ListEmployeesComponent implements OnInit {

  current_date= new Date();
  employees: Employee[];
  displayedColumns = ['id', 'name', 'deptId', 'action'];
  dataSource: MatTableDataSource<Employee>;

  constructor(private employeeService: EmployeeService, private router: Router) {
    console.log("list-employees - constructor");
  }

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  ngOnInit() {
    console.log("list-employees - ngOnInit");
    this.loadEmployees();
  }

  delete(id: number): void {
    console.log('id=' + id);
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log('delete: ' + JSON.stringify(data));
      // should call the API again to get the remaining employees
      this.employees = this.employees.filter(e => e.id != id);
	    this.dataSource = new MatTableDataSource(this.employees);
	    this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  edit(e: Employee): void {
    localStorage.setItem('selectedEmployee', JSON.stringify(e));
    this.router.navigate(['edit-employee']);
  }

  loadEmployees() {
    this.employeeService.getEmployees().subscribe(data => {
      console.log('load employees data ', JSON.stringify(data));
      this.employees = data.body;
      this.dataSource = new MatTableDataSource(data.body);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    },
      error => console.log('oops ', error));
  }
}