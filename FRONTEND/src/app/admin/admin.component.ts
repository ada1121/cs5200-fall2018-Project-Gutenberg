import { Component, OnInit } from '@angular/core';
import {Customer} from '../../models/customer.model.client';
import {AdminServiceClient} from '../../services/admin.service.client';
import {Artist} from '../../models/movie.model.client';
import {Event} from '../../models/event.model.client';
import {Venue} from '../../models/venue.model.client';
import {BandsintownClient} from '../../services/movie.service.client';
import {Location} from '@angular/common';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  persons: Response;
  comments: Response;
  users: Response;
  shows: Response;
  tickets: Response;

  artist = {};
  artists: Artist[];
  event = {};
  events: Event[];
  keyword = '';
  venue: Venue[];

  constructor(
    private service: AdminServiceClient,
    private service1: BandsintownClient,
    private location: Location
  ) { }

  searchPerson = () =>
    this.service.getPersons()
      .then(response => this.persons = response);

  searchAllUsers = () =>
    this.service.getAllUsers()
      .then(response => this.users = response);

  searchComment = () =>
    this.service.getComments()
      .then(response => this.comments = response);

  searchTicket = () =>
    this.service.getTickets()
      .then(response => this.tickets = response);

  deletePerson = (id) =>
    this.service.deletePersonById(id);

  deleteComment = (id) =>
    this.service.deleteCommentById(id);

  deleteTicket = (id) =>
    this.service.deleteTicketById(id);

  deleteShow = (id) =>
    this.service.deleteShowById(id);

  search = (name) =>
    this.service1.findArtistByKeyword(name)
      .then(artist => this.artist = artist)

  details = name =>
    this.service1
      .findEventbyArtist(name)
      .then(response => this.events = response)
      .then(location => this.venue = location.venue)

  goBack(): void {
    this.location.back();
  }

  searchShow = () =>
    this.service.getShows()
      .then(show => this.shows = show)

  ngOnInit() {
  }

}
