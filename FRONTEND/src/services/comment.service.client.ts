import {Injectable} from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Comment} from '../models/comment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class CommentServiceClient {

  private commentUrl = 'http://localhost:8080/api/comment'; // url to comment api
  private url1 = 'http://localhost:8080/api/customer';

  constructor(
    private http: HttpClient
  ) {}

  getComments (): Observable<Comment> {
    return this.http.get<Comment>(this.commentUrl);
  }

  getCommment(id: number): Observable<Comment> {
    const url = `${this.commentUrl}/${id}`;
    return this.http.get<Comment>(url);
  }

  addComment (comment: Comment): Observable<Comment> {
      return this.http.post<Comment>(`${this.url1}/${comment.customer_id}/show/${comment.show_id}/comment`,
        comment, httpOptions);
  }

  addCommentadmin (comment: Comment): Observable<Comment> {
    return this.http.post<Comment>(`${this.url1}/${comment.customer_id}/show/${comment.show_id}/comment`,
      comment, httpOptions);
  }


  updateComment (id: number, comment: Comment): Observable<any> {
    return this.http.put<Comment>(`${this.commentUrl}/${id}`, comment, httpOptions);
  }


}
