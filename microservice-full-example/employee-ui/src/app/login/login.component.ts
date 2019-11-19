import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formGroup: FormGroup;
  invalid: boolean;
  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [Validators.required]);

  getEmailErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
      this.email.hasError('email') ? 'Not a valid email' :
        '';
  }

  getPasswordErrorMessage() {
    return this.password.hasError('required') ? 'You must enter a value' : '';
  }

  constructor(private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.formGroup = this.formBuilder.group(
      {
        email: ['', Validators.required],
        password: ['', Validators.required]
      }
    )
  }

  login(): void {
    /*
    this.submitted = true;

    if (this.formGroup.invalid) {
      return;
    }
    */

   if (this.email.value == '' || this.password.value == '') {
     return;
   }
    else if (this.email.value == 'a@a.a' && this.password.value == '1111') {
      // should call auth source to validate the credentials, here i am using test data
      this.router.navigate(['list-employees']);
    } else {
      this.invalid = true;
    }
  }
}