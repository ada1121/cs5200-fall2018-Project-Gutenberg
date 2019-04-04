import { Component, OnInit } from '@angular/core';
import {Artist} from '../../models/movie.model.client';
import {BandsintownClient} from '../../services/movie.service.client';
import {Event} from '../../models/event.model.client';
import {Venue} from '../../models/venue.model.client';

@Component({
  selector: 'app-movie-search',
  templateUrl: './artist-search.component.html',
  styleUrls: ['./artist-search.component.css']
})
export class ArtistSearchComponent implements OnInit {

  constructor(private service: BandsintownClient) {}

  artist = {};
  artists: Artist[];
  event = {};
  events: Event[];
  keyword = '';
  venue: Venue[];

  search = (name) =>
    this.service.findArtistByKeyword(name)
        .then(artist => this.artist = artist)

  details = name =>
    this.service
      .findEventbyArtist(name)
      .then(response => this.events = response)
      .then(location => this.venue = location.venue)

  ngOnInit() {
  }

}
