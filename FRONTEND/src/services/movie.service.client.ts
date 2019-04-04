import {Injectable} from '@angular/core';

@Injectable()
export class BandsintownClient {
  url = 'https://rest.bandsintown.com/artists/';
  url1 = '?app_id=44847ea44d49dc3f93cfa2aafc0dc9ee';
  url2 = '/events?app_id=44847ea44d49dc3f93cfa2aafc0dc9ee';

  localhost = 'http://localhost:3000/api/';


  findArtistByKeyword = keyword => {
    return fetch(this.url + keyword + this.url1)
    .then(res => res.json());
  }

  findEventbyArtist = keyword =>
    fetch(this.url + keyword + this.url2)
      .then(res => res.json())
}
