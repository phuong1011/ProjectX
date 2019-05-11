import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {AlbumService} from '../../../services/album/album.service';

@Component({
  selector: 'app-editalbum',
  templateUrl: './editalbum.component.html',
  styleUrls: ['./editalbum.component.scss']
})
export class EditalbumComponent implements OnInit {

  constructor(private route: ActivatedRoute, private albumService: AlbumService) { }
  id: string;
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.albumService.getAlbumById(this.id);
  }

}
