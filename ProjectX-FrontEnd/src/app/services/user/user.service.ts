import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {user} from '../../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user: user;
  url = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }
  checkUser(email: string) {
    return this.http.get(this.url + 'user/email/' + email);
  }
  postUser(formData: user) {
    return this.http.post(this.url + 'user', formData);
  }
}
