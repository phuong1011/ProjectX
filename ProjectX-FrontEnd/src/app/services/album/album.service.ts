import { Injectable } from '@angular/core';
import { album } from 'src/app/models/album';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  formData : album;
  list: album[];
  album: album;

  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/";

  refreshList(){
    this.http.get(this.url+'album/artist/1')
    .toPromise().then(res => {
      this.list = res as album[];
      console.log(res);
    });
  }

  postCategory(formData : album){
    return this.http.post(this.url+'album',formData);
  }

  getAlbumById(id) {
    this.http.get(this.url + 'album/' + id)
      .toPromise().then(res => {
      this.album = res as album;
    });
  }

  putCategory(formData : album){
    return this.http.put(this.url+'/album',formData);
  }

  deleteAlbum(id : number){
    return this.http.delete(this.url+'/album/'+id);
  }
}
