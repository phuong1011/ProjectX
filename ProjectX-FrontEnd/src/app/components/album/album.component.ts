import { Component, OnInit } from '@angular/core';
import { AlbumService } from 'src/app/services/album/album.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.scss']
})
export class AlbumComponent implements OnInit {

  constructor(private service: AlbumService,private toastr: ToastrService) { }

  ngOnInit() {
    this.service.refreshList();
  }

}
