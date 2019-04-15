import { Injectable } from '@angular/core';
import { AngularFireAuth } from 'angularfire2/auth';
import * as firebase from 'firebase';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  firebaseUser$ : Observable<firebase.User>;

  constructor(private auth: AngularFireAuth) {
    this.firebaseUser$ = auth.authState;
   }

  login(){
    this.auth.auth.signInWithRedirect(new firebase.auth.GoogleAuthProvider);
  }

  logout(){
    this.auth.auth.signOut();
  }
}
