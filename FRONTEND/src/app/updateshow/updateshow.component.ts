import { Component, OnInit } from '@angular/core';
import {Comment} from '../../models/comment';
import {CommentServiceClient} from '../../services/comment.service.client';
import {Location} from '@angular/common';
import {ActorServiceClient} from '../../services/actor.service.client';

@Component({
  selector: 'app-updateshow',
  templateUrl: './updateshow.component.html',
  styleUrls: ['./updateshow.component.css']
})
export class UpdateshowComponent implements OnInit {

  submitted = false;
  actor_id;
  show_id;

  constructor(
    private updateshowService: ActorServiceClient,
    private location: Location
  ) { }


  ngOnInit() {
  }

  save() {
    this.updateshowService.updateShow(this.actor_id, this.show_id)
      .subscribe(data => console.log(data), error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goBack(): void {
    this.location.back();
  }
}
