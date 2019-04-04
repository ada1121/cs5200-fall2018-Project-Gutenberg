import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Comment} from '../models/comment';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ActorServiceClient {
  private findActorUrl = 'http://localhost:8080/api/actor';


  constructor(
    private http: HttpClient
  ) {
  }

  findShowByActorId(id) {
    return fetch(this.findActorUrl + '/' + id + '/show')
      .then(res => res.json());
  }

  updateShow (actor_id: number, show_id: number): Observable<any> {
    return this.http.put(`${this.findActorUrl}/${actor_id}/show/${show_id}`, httpOptions);
  }
}
