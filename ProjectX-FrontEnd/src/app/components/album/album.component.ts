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

  onDelete(id: number, size: number) {
    if (size == 0) {
      if (confirm('Are you sure to delete this record?')) {
        this.service.deleteAlbum(id).subscribe(res => {
          this.service.refreshList();
          this.toastr.warning('Deleted successfully', 'Album plan');
        });
      }
    } else {
      this.toastr.warning('Cannot delete album with 1 or more track', 'Album plan');
    }
  }

}
