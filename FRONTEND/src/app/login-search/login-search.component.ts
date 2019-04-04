import { Component, OnInit } from '@angular/core';
import {Artist} from '../../models/movie.model.client';
import {Event} from '../../models/event.model.client';
import {Venue} from '../../models/venue.model.client';
import {AdminServiceClient} from '../../services/admin.service.client';
import {BandsintownClient} from '../../services/movie.service.client';
import {TicketServiceClient} from '../../services/ticket.service.client';
import {ActivatedRoute} from '@angular/router';
import {Customer} from '../../models/customer.model.client';

@Component({
  selector: 'app-login-search',
  templateUrl: './login-search.component.html',
  styleUrls: ['./login-search.component.css']
})
export class LoginSearchComponent implements OnInit {

  persons: Response;
  comments: Response;

  artist = {};
  artists: Artist[];
  event = {};
  events: Event[];
  keyword = '';
  venue: Venue[];

  tickets: Response;

  customer: Customer = new Customer();

  comments1: Response;

  constructor(
    private service: AdminServiceClient,
    private service1: BandsintownClient,
    private service2: TicketServiceClient,
    private routing: ActivatedRoute

  ) { }


  searchPerson = () =>
    this.service.getPersons()
      .then(response => this.persons = response)

  searchComment = () =>
    this.service.getComments()
      .then(response => this.comments = response)

  searchowncomment = (id) =>
    this.service.getCommentsByCustomerId(id)
      .then(response => this.comments1 = response)

  search = (name) =>
    this.service1.findArtistByKeyword(name)
      .then(artist => this.artist = artist)

  details = name =>
    this.service1
      .findEventbyArtist(name)
      .then(response => this.events = response)
      .then(location => this.venue = location.venue)

  searchcustomerticket = (customerid) =>
    this.service2.getTicketByCustomer(customerid)
      .then(ticket => this.tickets = ticket)

  deleteTicketById1 = (ticketid) =>
    this.service.deleteTicketById(ticketid)

  ngOnInit() {
    this.routing.params.subscribe(params => this.customer.id = params['customerid']);
  }

}
