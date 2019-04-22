import { Component, OnInit } from '@angular/core';
import { PlaylistService } from 'src/app/services/playlist/playlist.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.scss']
})
export class PlaylistComponent implements OnInit {

  constructor(private service: PlaylistService) { }

  ngOnInit() {
    this.playlistByAdmin();
  }

  playlistByAdmin() {
    this.service.playlistByAdmin();
  }
}
