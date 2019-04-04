import { Component, OnInit } from '@angular/core';

import {Customer} from '../../models/customer.model.client';
import {SignupServiceClient} from '../../services/signup.service.client';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  customer: Customer = new Customer();
  submitted = false;

  constructor(
    private signupService: SignupServiceClient,
  ) { }

  ngOnInit() {
  }

  newCustomer(): void {
    this.submitted = false;
    this.customer = new Customer();
  }

  save() {
    this.signupService.addCustomer(this.customer)
      .subscribe(data => console.log(data), error => console.log(error));
    this.customer = new Customer();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
