import { Component, OnInit } from '@angular/core';
import {Comment} from '../../models/comment';

import {CommentServiceClient} from '../../services/comment.service.client';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  comment: Comment = new Comment();
  submitted = false;

  constructor(
    private commentService: CommentServiceClient,
    private routing: ActivatedRoute,
    private location: Location
  ) { }


  ngOnInit() {
    this.routing.params.subscribe(params => this.comment.customer_id = params['customerid1']);
  }

  newComment(): void {
    this.submitted = false;
    this.comment = new Comment();
  }

  save() {
    this.commentService.addComment(this.comment)
      .subscribe(data => console.log(data), error => console.log(error));
    this.comment = new Comment();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goBack(): void {
    this.location.back();
  }

}
