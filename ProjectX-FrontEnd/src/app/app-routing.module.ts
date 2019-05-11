import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CategoryComponent } from './components/category/category.component';
import { AlbumComponent } from './components/album/album.component';
import { NewalbumComponent } from './components/album/newalbum/newalbum.component';
import { LoginComponent } from './components/login/login.component';
import { AuthguardService } from './services/authGuard/authguard.service';
<<<<<<< HEAD
import {EditalbumComponent} from './components/album/editalbum/editalbum.component';
=======
import { PlaylistComponent } from './components/playlist/playlist.component';
import { NewplaylistComponent } from './components/playlist/newplaylist/newplaylist.component';
>>>>>>> c972b6681c567717c7ae6a8a15d667955866cdd7

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },

  { path: 'category', component: CategoryComponent ,canActivate: [AuthguardService] },
  { path: 'album', component: AlbumComponent ,canActivate: [AuthguardService]},
<<<<<<< HEAD
  { path: 'newalbum', component: NewalbumComponent ,canActivate: [AuthguardService] },
  { path: 'editalbum/:id', component: EditalbumComponent ,canActivate: [AuthguardService] }
=======
  { path: 'playlist', component: PlaylistComponent ,canActivate: [AuthguardService]},
  { path: 'newalbum', component: NewalbumComponent ,canActivate: [AuthguardService] },
  { path: 'newplaylist', component: NewplaylistComponent ,canActivate: [AuthguardService]}
>>>>>>> c972b6681c567717c7ae6a8a15d667955866cdd7
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
