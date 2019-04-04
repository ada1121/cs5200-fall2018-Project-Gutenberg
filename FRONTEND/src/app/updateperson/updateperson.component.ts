import { Component, OnInit } from '@angular/core';
import {AdminServiceClient} from '../../services/admin.service.client';
import {Customer} from '../../models/customer.model.client';
import {ActivatedRoute, Route, Router, RouterLink} from '@angular/router';
import {Params} from '@angular/router';

@Component({
  selector: 'app-updateperson',
  templateUrl: './updateperson.component.html',
  styleUrls: ['./updateperson.component.css']
})
export class UpdatepersonComponent implements OnInit {

  personpass: number;
  personfk: Customer = new Customer();
  customer: Customer = new Customer();
  submitted = false;
  userId;

  constructor(
    private service: AdminServiceClient, private routing: ActivatedRoute

  // private route: RouterLink
  ) { }

  // personpass = this.passUpdatePerson(id);

  updatePerson = (firstName: string, lastName: string, username: string, password: string) => {
    this.personfk.firstName = firstName;
    this.personfk.lastName = lastName;
    this.personfk.username = username;
    this.personfk.password = password;
  };

  passUpdatePerson = (id: number) => {this.personfk.id = id; };

  // newCustomer(): void {
  //   this.submitted = false;
  //   this.customer = new Customer();
  // }

  // save() {
  //   this.service.updatePersonById(id, this.personfk)
  //     .subscribe(data => console.log(data), error => console.log(error));
  //   // this.customer = new Customer();
  // }

  onSubmit() {
    this.submitted = true;
    // this.personfk.id = this.userId
    this.service.updatePersonById(this.personfk.id, this.personfk);
  }

  ngOnInit() {
    this.routing.params.subscribe(params => this.personfk.id = params['userId']);
    // this.route.queryParams
    //   .subscribe((params: Params) => {
    //     this.personfk.id = params['p.id'];
    //     console.log(params)
    //     console.log(this.personfk.id);
    //   });
  }

}
