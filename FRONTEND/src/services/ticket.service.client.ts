import {Injectable} from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Ticket} from '../models/ticket.model.client';
import {Comment} from '../models/comment';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class TicketServiceClient {

  private ticketUrl = 'http://localhost:8080/api/ticket'; // url to comment api
  private ticketpersonUrl = 'http://localhost:8080/api/customer';
  private ticketstaffUrl = 'http://localhost:8080/api/staff';

  constructor(
    private http: HttpClient
  ) {
  }

  addTicket(ticket: Ticket): Observable<Ticket> {
    return this.http
      .post<Ticket>(`${this.ticketpersonUrl}/${ticket.customer_id}/location/${ticket.location_id}/staff/${ticket.staff_id}/ticket`,
      ticket, httpOptions);
  }

  getTicketByStaff(id) {
    return fetch(`${this.ticketstaffUrl}/${id}/ticket`)
      .then(res => res.json());
  }

  getTicketByCustomer(id) {
    return fetch(`${this.ticketpersonUrl}/${id}/ticket`)
      .then(res => res.json());
  }

  getTicket(): Observable<Ticket> {
    return this.http.get<Ticket>(this.ticketUrl);
  }

  getTickets(id: number): Observable<Ticket> {
    const url = `${this.ticketUrl}/${id}`;
    return this.http.get<Ticket>(url);
  }

}



