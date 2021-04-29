import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AddCategoryService } from 'src/app/services/add-category.service';
@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
  form: FormGroup;
 
  constructor(private addCategoryService: AddCategoryService,private router:Router, private http: HttpClient) { }

  ngOnInit(): void {
   
    this.form = new FormGroup({
      categoryName:new FormControl("",Validators.required),
  });
}
  AddCategory(){
    console.log(this.form.value);
    this.addCategoryService.saveForm(this.form.value)
    .subscribe(
      data =>{
      console.log(data);
        if(data){
          alert("category added successfully");
          this.router.navigate(["admin"]);
        }
        if(data==null){
          alert("category already exists");
        }
    });
  }   

  

}
