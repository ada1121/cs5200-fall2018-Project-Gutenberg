import {Injectable} from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Customer} from '../models/customer.model.client';

import {catchError, map, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class LoginServiceClient {

  private loginUrl = 'http://localhost:8080/api/login';
  private currentUrl = 'http://localhost:8080/api/currentUser';

  username: string;
  password: string;
  firstname: string;
  lastname: string;
  id: number;
  newCustomer: Observable<Customer>;

  constructor(
   private http: HttpClient
  ) {}

     loginPerson (customer: Customer): Observable<Customer> {
      return this.http.post<Customer>(this.loginUrl, customer, httpOptions);
  }


  currentUser = () =>
    fetch(this.currentUrl, {
      credentials: 'include'
    }).then(response => response.json())

}
