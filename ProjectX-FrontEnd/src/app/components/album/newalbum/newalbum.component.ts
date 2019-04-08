import { Component, OnInit } from '@angular/core';
import { album } from 'src/app/models/album';
import { CategoryService } from 'src/app/services/category/category.service';
import { ToastrService } from 'ngx-toastr';
import { category } from 'src/app/models/category';
import { track } from 'src/app/models/track';

@Component({
  selector: 'app-newalbum',
  templateUrl: './newalbum.component.html',
  styleUrls: ['./newalbum.component.scss']
})
export class NewalbumComponent implements OnInit {

  constructor(private categoryService: CategoryService,private toastr: ToastrService) { }

  newAlbum: album;
  track: track;

  ngOnInit() {
    this.categoryService.refreshList();
    this.newAlbum = new album(0,"","","",new category(0,"","",""),"",[]);
    this.track = new track(0,"","","",0,"","ascascc");
  }

  addTrack(){
    console.log("begin");
    this.newAlbum.trackList.push(this.track);
    this.track = new track(0,"","","",0,"","ascascc");
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
