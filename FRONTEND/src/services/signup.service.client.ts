import {Injectable} from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Customer} from '../models/customer.model.client';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class SignupServiceClient {
  private signupUrl = 'http://localhost:8080/api/customer/register'; // url to comment api


  constructor(
    private http: HttpClient
  ) {}

  addCustomer (customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.signupUrl, customer, httpOptions);
  }


  updateCustomer (customer: Customer): Observable<any> {
    return this.http.put<Customer>(this.signupUrl, customer, httpOptions);
  }
}
