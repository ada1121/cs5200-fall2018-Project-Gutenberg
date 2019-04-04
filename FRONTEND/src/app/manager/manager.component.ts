import { Component, OnInit } from '@angular/core';
import {AdminServiceClient} from '../../services/admin.service.client';
import {BandsintownClient} from '../../services/movie.service.client';
import {Artist} from '../../models/movie.model.client';
import {Event} from '../../models/event.model.client';
import {Venue} from '../../models/venue.model.client';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  comments: Response;
  staffs: Response;
  actors: Response;

  artist = {};
  artists: Artist[];
  event = {};
  events: Event[];
  keyword = '';
  venue: Venue[];


  constructor(
    private service: AdminServiceClient,
    private service1: BandsintownClient
  ) { }


  searchStaffs = () =>
    this.service.getStaffs()
      .then(response => this.staffs = response)

  searchActor = () =>
    this.service.getActor()
      .then(response => this.actors = response)

  searchComment = () =>
    this.service.getComments()
      .then(response => this.comments = response)

  search = (name) =>
    this.service1.findArtistByKeyword(name)
      .then(artist => this.artist = artist)

  details = name =>
    this.service1
      .findEventbyArtist(name)
      .then(response => this.events = response)
      .then(location => this.venue = location.venue)


  ngOnInit() {
  }

}
