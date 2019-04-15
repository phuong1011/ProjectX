import { Component } from '@angular/core';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ProjectX-FrontEnd';

  constructor(private auth: LoginService) {
    console.log(auth.firebaseUser$.subscribe(user => console.log(user)));
  }

  logout(){
    this.auth.logout();
  }
}
