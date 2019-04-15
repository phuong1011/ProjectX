import { Injectable } from '@angular/core';
import { LoginService } from '../login.service';
import { Router, CanActivate } from '@angular/router';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService implements CanActivate{

  constructor(private auth: LoginService, private router: Router) { }

  canActivate(){
    return this.auth.firebaseUser$.map(user => {
      if (user) return true;

      this.router.navigate(['/login']);
      return false;
    })
  }
}
