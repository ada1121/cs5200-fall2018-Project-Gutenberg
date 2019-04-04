import { Component, OnInit } from '@angular/core';
import {AdminServiceClient} from '../../services/admin.service.client';
import {ActorServiceClient} from '../../services/actor.service.client';
import {Show} from '../../models/show';

@Component({
  selector: 'app-actor',
  templateUrl: './actor.component.html',
  styleUrls: ['./actor.component.css']
})
export class ActorComponent implements OnInit {

  shows: Response;
  comments: Response;

  actor_id = '';


  constructor(
    private service: AdminServiceClient,
    private service1: ActorServiceClient,
  ) { }


  searchComment = () =>
    this.service.getComments()
      .then(response => this.comments = response)

  searchactorshow = (actor_id) =>
    this.service1.findShowByActorId(actor_id)
      .then(show => this.shows = show)

  ngOnInit() {
  }

}
