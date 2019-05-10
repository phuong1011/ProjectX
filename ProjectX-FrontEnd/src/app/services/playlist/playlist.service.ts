import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { playlist } from 'src/app/models/playlist';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  formData : playlist;
  list: playlist[];

  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/";

  playlistByAdmin(){
    this.http.get(this.url+'playlist/admin')
    .toPromise().then(res => {
      this.list = res as playlist[];
      console.log(res);
    });
  }

  postPlaylist(formData : playlist){
    return this.http.post(this.url+'playlist',formData);
  }

  putPlaylist(formData : playlist){
    return this.http.put(this.url+'/playlist',formData);
  }

  deletePlaylist(id : number){
    return this.http.delete(this.url+'/playlist/'+id);
  }
}
