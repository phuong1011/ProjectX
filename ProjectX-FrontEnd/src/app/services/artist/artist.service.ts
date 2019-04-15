import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {artist} from '../../models/artist';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  formData: artist;
  constructor(private http: HttpClient) { }

  url = 'http://localhost:8080/';

  postArist(formData: artist) {
    return this.http.post(this.url + '/artist',formData);
  }
}
