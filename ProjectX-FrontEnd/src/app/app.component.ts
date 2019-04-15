import { Component } from '@angular/core';
import { LoginService } from './services/login.service';
import {UserService} from './services/user/user.service';
import {user} from './models/user';
import {artist} from './models/artist';
import {ArtistService} from './services/artist/artist.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ProjectX-FrontEnd';

  user: user;
  artist: artist;
  constructor(private auth: LoginService, private userService: UserService, private artistService: ArtistService) {
    console.log(auth.firebaseUser$.subscribe(userFirebase => {
      console.log(userFirebase);
        if (userFirebase) {
          userService.checkUser(userFirebase.email).subscribe(res => {
            if (res) {
              this.user = res as user;
              localStorage.setItem('USER_INFO', JSON.stringify(this.user));
            } else {
              this.user = this.convertUserFirebaseToUser(this.user, userFirebase);
              userService.postUser(this.user).subscribe(response => {
                if (response) {
                  this.user = response as user;
                  this.artist = this.convertArtistFromUser(this.artist, user);
                  artistService.postArist(this.artist).subscribe(responseArtist => {
                    this.artist = responseArtist as artist;
                    localStorage.setItem('ARTIST_INFO', JSON.stringify(this.artist));
                  });
                }
              });
            }
          });
        }
      })
    );
  }

  logout() {
    this.auth.logout();
  }

  convertUserFirebaseToUser(user1: user, userFirebase) {
    user1 = new user(null, null, null, null, null, null, null);
    user1.userId = userFirebase.uid;
    user1.displayName = userFirebase.displayName;
    user1.email = userFirebase.email;
    user1.gender = 0;
    user1.dob = '';
    user1.providerId = '1';
    user1.typeId = {
      typeId: 2,
      typeName: 'Artist'
    };
    return user1;
  }

  convertArtistFromUser(artist1: artist, user1) {
    artist1 = new artist(null, user1.displayName, 'new Artist', 'customUrl',  'background', user1.userId);
    return artist1;
  }
}
