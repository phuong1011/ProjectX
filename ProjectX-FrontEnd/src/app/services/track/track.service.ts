import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { track } from 'src/app/models/track';

@Injectable({
  providedIn: 'root'
})
export class TrackService {

  list: track[];

  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/";

  refreshList(){
    this.http.get(this.url+'alltrack')
    .toPromise().then(res => {
      this.list = res as track[];
      console.log(res);
    });
  }
}
