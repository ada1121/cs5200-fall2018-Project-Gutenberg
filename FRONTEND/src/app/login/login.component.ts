import { Component, OnInit } from '@angular/core';

import {Customer} from '../../models/customer.model.client';
import {LoginServiceClient} from '../../services/login.service.client';
import {SignupServiceClient} from '../../services/signup.service.client';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  customer: Customer = new Customer();
  submitted = false;
  message: string;
  loggedIn = false;

  // new
  // username: string;
  // password: string;

  constructor(
    private route: Router, // new
    private loginService: LoginServiceClient,
  ) { }

  ngOnInit() {
  }

  newCustomer(): void {
    this.submitted = false;
    this.customer = new Customer();
  }

  login() {
    this.loginService.loginPerson(this.customer)
      .subscribe(user => {
        console.log(user);
        this.customer = user;
        this.loggedIn = true;
      });
  }
}
