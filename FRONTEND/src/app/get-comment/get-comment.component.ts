import { Component, OnInit } from '@angular/core';
import {Comment} from '../../models/comment';
import {CommentServiceClient} from '../../services/comment.service.client';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-get-comment',
  templateUrl: './get-comment.component.html',
  styleUrls: ['./get-comment.component.css']
})
export class GetCommentComponent implements OnInit {

  comment: Comment = new Comment();
  submitted = false;
  message: string;

  constructor(
    private commentService: CommentServiceClient,
    private routing: ActivatedRoute,
    private location: Location
    ) { }


  ngOnInit(): void {
    this.routing.params.subscribe(params => this.comment.id = params['commentId']);
    // const id = +this.route.snapshot.paramMap.get('id');
    // this.commentService.getComment(id)
    //   .subscribe(comment => this.comment = comment);

  }

  update(): void {
    this.submitted = true;
    this.commentService.updateComment(this.comment.id, this.comment)
      .subscribe(() => this.message = 'Comment Updated Successfully!');
  }

  // delete(): void {
  //   this.submitted = true;
  //   this.commentService.deleteComment(this.comment)
  //       .subscribe(() => this.message = 'Comment Updated Successfully!');
  // }

  goBack(): void {
    this.location.back();
  }
}
