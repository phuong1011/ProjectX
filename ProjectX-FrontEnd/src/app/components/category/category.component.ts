import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { CategoryService } from 'src/app/services/category/category.service';
import { ToastrService } from 'ngx-toastr';
import { category } from 'src/app/models/category';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  @ViewChild('btnClose') btnClose : ElementRef;

  constructor(private service: CategoryService,private toastr: ToastrService) { }

  newCate: category;
  updateCate: category;

  ngOnInit() {
    this.service.refreshList();
    this.newCate = new category(0,null,null,null);
    this.updateCate = new category(0,null,null,null);
  }

  populateForm(cate: category) {
    console.log(cate);
    this.updateCate = cate;
  }

  onDelete(id: number) {
    if (confirm('Are you sure to delete this record?')) {
      this.service.deleteCategory(id).subscribe(res => {
        this.service.refreshList();
        this.toastr.warning('Deleted successfully', 'Category plan');
      });
    }
  }

  selectFile(e){
    if(e.target.id == "image"){
      this.newCate.image_path = e.target.value;
    }else{
      this.updateCate.image_path = e.target.value;
    }
  }

  onSubmit(event){
    event.preventDefault();
    event.target.id == "addForm" ? this.insertRecord() : this.updateRecord();
  }

  insertRecord(){
    this.service.postCategory(this.newCate).subscribe(res => {
      this.toastr.success('Inserted successfully', 'Category plan');
      this.resetForm();
      this.service.refreshList();
    });
  }

  updateRecord() {
    this.service.putCategory(this.updateCate).subscribe(res => {
      this.toastr.info('Updated successfully', 'Category plan');
      this.resetForm();
      this.service.refreshList();
    });

  }

  resetForm(){
    //this.btnClose.nativeElement.click();
  }

}
