import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NabbarComponent } from './components/nabbar/nabbar.component';
import { LoginService } from './services/login.service';

@NgModule({
  declarations: [
    AppComponent,
    NabbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
