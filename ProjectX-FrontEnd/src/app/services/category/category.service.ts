import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { category } from 'src/app/models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  formData: category;
  list: category[];

  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/";

  refreshList(){
    this.http.get(this.url+'category')
    .toPromise().then(res => this.list = res as category[]);
  }

  postCategory(formData : category){
    return this.http.post(this.url+'/category',formData);
  }

  putCategory(formData : category){
    return this.http.put(this.url+'/category',formData);
  }

  deleteCategory(id : number){
    return this.http.delete(this.url+'/category/'+id);
  }

}
