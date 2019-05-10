import { Component, OnInit } from '@angular/core';
import { album } from 'src/app/models/album';
import { CategoryService } from 'src/app/services/category/category.service';
import { ToastrService } from 'ngx-toastr';
import { category } from 'src/app/models/category';
import { track } from 'src/app/models/track';
import { AlbumService } from 'src/app/services/album/album.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-newalbum',
  templateUrl: './newalbum.component.html',
  styleUrls: ['./newalbum.component.scss']
})
export class NewalbumComponent implements OnInit {

  constructor(private categoryService: CategoryService,private albumService: AlbumService,private toastr: ToastrService, private router: Router) { }

  newAlbum: album;
  track: track;

  ngOnInit() {
    this.categoryService.refreshList();
    this.newAlbum = new album(0,"","","",new category(0,"","",""),{artistId: 1},[]);
    this.track = new track(0,"","","","");
  }

  addTrack() {
    console.log("begin");
    this.newAlbum.trackList.push(this.track);
    this.track = new track(0,"","","","1");
  }

  saveAlbum(){
    console.log(JSON.stringify(this.newAlbum));
    if(this.newAlbum.trackList.length > 0){
      this.albumService.postCategory(this.newAlbum).subscribe(res => {
        this.router.navigate(['/album']);
        this.toastr.success('Inserted successfully', 'Album plan');
      });
    }else{
      this.toastr.warning('Please insert 1 or more track', 'Album plan');
    }
  }

  deleteTrack(index){
    console.log(index);
    this.newAlbum.trackList.splice(index,1);
  }

  selectFile(e){
    if(e.target.id == "image"){
      this.newAlbum.imagePath = e.target.value;
    }else{
      this.newAlbum.imagePath = e.target.value;
    }
  }

  selectFileTrack(e){
    if(e.target.id == "image"){
      this.track.audioPath = e.target.value;
    }else{
      this.track.audioPath = e.target.value;
    }
  }

}
