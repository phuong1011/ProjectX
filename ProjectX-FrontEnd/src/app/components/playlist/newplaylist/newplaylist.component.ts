import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category/category.service';
import { ToastrService } from 'ngx-toastr';
import { category } from 'src/app/models/category';
import { track } from 'src/app/models/track';
import { PlaylistService } from 'src/app/services/playlist/playlist.service';
import { Router } from '@angular/router';
import { playlist } from 'src/app/models/playlist';

@Component({
  selector: 'app-newplaylist',
  templateUrl: './newplaylist.component.html',
  styleUrls: ['./newplaylist.component.scss']
})
export class NewplaylistComponent implements OnInit {

  constructor(private categoryService: CategoryService,private playlistervice: PlaylistService,private toastr: ToastrService, private router: Router) { }

  newPlaylist: playlist;
  track: track;

  ngOnInit() {
    this.categoryService.refreshList();
    this.newPlaylist = new playlist(0,"","",0,new category(0,"","",""),{userId: ""},[]);
    this.track = new track(0,"","","","");
  }

  addTrack(){
    console.log("begin");
    this.newPlaylist.tracks.push(this.track);
    this.track = new track(0,"","","","1");
  }

  saveAlbum(){
    console.log(JSON.stringify(this.newPlaylist));
    if(this.newPlaylist.tracks.length > 0){
      this.playlistervice.postPlaylist(this.newPlaylist).subscribe(res => {
        this.router.navigate(['/album']);
        this.toastr.success('Inserted successfully', 'Album plan');
      });
    }else{
      this.toastr.warning('Please insert 1 or more track', 'Album plan');
    }
  }

  deleteTrack(index){
    console.log(index);
    this.newPlaylist.tracks.splice(index,1);
  }

  selectFile(e){
    if(e.target.id == "image"){
      this.newPlaylist.imagePath = e.target.value;
    }else{
      this.newPlaylist.imagePath = e.target.value;
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
