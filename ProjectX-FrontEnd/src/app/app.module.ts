import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NabbarComponent } from './components/nabbar/nabbar.component';
import { LoginService } from './services/login.service';
import { HomeComponent } from './components/home/home.component';
import { CategoryComponent } from './components/category/category.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from "@angular/forms";
import { ToastrModule } from 'ngx-toastr';
import { AlbumComponent } from './components/album/album.component';
import { NewalbumComponent } from './components/album/newalbum/newalbum.component';
import { EditalbumComponent } from './components/album/editalbum/editalbum.component';

@NgModule({
  declarations: [
    AppComponent,
    NabbarComponent,
    HomeComponent,
    CategoryComponent,
    AlbumComponent,
    NewalbumComponent,
    EditalbumComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ToastrModule.forRoot()
  ],
  providers: [LoginService,HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
