import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CategoryComponent } from './components/category/category.component';
import { AlbumComponent } from './components/album/album.component';
import { NewalbumComponent } from './components/album/newalbum/newalbum.component';
import { LoginComponent } from './components/login/login.component';
import { AuthguardService } from './services/authGuard/authguard.service';
import { EditalbumComponent } from './components/album/editalbum/editalbum.component';
import { PlaylistComponent } from './components/playlist/playlist.component';
import { NewplaylistComponent } from './components/playlist/newplaylist/newplaylist.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },

  { path: 'category', component: CategoryComponent ,canActivate: [AuthguardService] },
  { path: 'album', component: AlbumComponent ,canActivate: [AuthguardService]},
  { path: 'newalbum', component: NewalbumComponent ,canActivate: [AuthguardService] },
  { path: 'editalbum/:id', component: EditalbumComponent ,canActivate: [AuthguardService] },
  { path: 'playlist', component: PlaylistComponent ,canActivate: [AuthguardService]},
  { path: 'newalbum', component: NewalbumComponent ,canActivate: [AuthguardService] },
  { path: 'newplaylist', component: NewplaylistComponent ,canActivate: [AuthguardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
