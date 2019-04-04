import { Component, OnInit } from '@angular/core';
import {BandsintownClient} from '../../services/movie.service.client';
import {Artist} from '../../models/movie.model.client';
import {Event} from '../../models/event.model.client';
import {Venue} from '../../models/venue.model.client';
import {Ticket} from '../../models/ticket.model.client';
import {TicketServiceClient} from '../../services/ticket.service.client';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {

  constructor(
    private service: BandsintownClient,
    private service1: TicketServiceClient
  ) {}

  artist = {};
  artists: Artist[];
  event = {};
  events: Event[];
  keyword = '';
  venues: Venue[];

  tickets: Response;

  search = (name) =>
    this.service.findArtistByKeyword(name)
      .then(artist => this.artist = artist)

  details = name =>
    this.service
      .findEventbyArtist(name)
      .then(response => this.events = response)
      .then(location => this.venues = location.venue)

  searchstaffticket = (staffid) =>
    this.service1.getTicketByStaff(staffid)
      .then(ticket => this.tickets = ticket);

  ngOnInit() {
  }

}
