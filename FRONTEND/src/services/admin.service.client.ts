import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Customer} from '../models/customer.model.client';
import {Observable} from 'rxjs';
import {Show} from '../models/show';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AdminServiceClient {
  private findPersonsUrl = 'http://localhost:8080/api/customer';
  private findCommentUrl = 'http://localhost:8080/api/comment';
  private PersonUrl = 'http://localhost:8080/api/person';
  private deleteCommentUrl = 'http://localhost:8080/api/comment';
  private showUrl = 'http://localhost:8080/api/';

  private findallusersUrl = 'http://localhost:8080/api/persons';
  private findallstaffUrl = 'http://localhost:8080/api/staff';
  private findallactorUrl = 'http://localhost:8080/api/actor';
  private findTicketUrl = 'http://localhost:8080/api/ticket';

  constructor(
    private http: HttpClient
  ) {}

  getPersons = () => {
    return fetch(this.findPersonsUrl)
      .then(res => res.json());
  }

  getAllUsers = () => {
    return fetch(this.findallusersUrl)
      .then(res => res.json());
  }

  getStaffs = () => {
    return fetch(this.findallstaffUrl)
      .then(res => res.json());
  }

  getActor = () => {
    return fetch(this.findallactorUrl)
      .then(res => res.json());
  }

  getComments = () => {
    return fetch(this.findCommentUrl)
      .then(res => res.json());
  }

  getCommentsByCustomerId = (id) => {
    return fetch(this.findPersonsUrl + '/' + id + '/comment')
      .then(res => res.json());
  }

  deletePersonById = (id: number) => {
    return this.http.delete<any>(`${this.PersonUrl}/${id}`, httpOptions).subscribe();
  }

  deleteCommentById = (id: number) => {
    return this.http.delete<any>(`${this.deleteCommentUrl}/${id}`, httpOptions).subscribe();
  }

  deleteTicketById = (id: number) => {
    return this.http.delete<any>(`${this.findTicketUrl}/${id}`, httpOptions).subscribe();
  }

  deleteShowById = (id: number) => {
    return this.http.delete<any>(`${this.showUrl}/show/${id}`, httpOptions).subscribe();
  }

  updatePersonById = (id: number, personfk: Customer) => {
    return this.http.put<any>(`${this.PersonUrl}/${id}`, personfk, httpOptions).subscribe();
  }

  createShows = (show: Show): Observable<Show> => {
    return this.http.post<Show>(`${this.showUrl}/actor/${show.actor_id}/show/`, show, httpOptions);
  }

  getShows = () => {
    return fetch(this.showUrl + '/show')
      .then(res => res.json());
  }

  getTickets = () => {
    return fetch(this.findTicketUrl)
      .then(res => res.json());
  }

}
