import { Component, OnInit } from '@angular/core';
import {Comment} from '../../models/comment';
import {Location} from '@angular/common';
import {AdminServiceClient} from '../../services/admin.service.client';
import {ActorServiceClient} from '../../services/actor.service.client';
import {Show} from '../../models/show';

@Component({
  selector: 'app-addshow',
  templateUrl: './addshow.component.html',
  styleUrls: ['./addshow.component.css']
})
export class AddshowComponent implements OnInit {

  show: Show = new Show();
  submitted = false;

  constructor(
    private service: AdminServiceClient,
    private service1: ActorServiceClient,
    private location: Location
  ) { }

  ngOnInit() {
  }

  save() {
    this.service.createShows(this.show)
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
