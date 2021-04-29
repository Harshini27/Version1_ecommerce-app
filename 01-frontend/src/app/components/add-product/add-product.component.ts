import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AddProductService } from 'src/app/services/add-product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  addprod: FormGroup;
 
  constructor(private addProductService: AddProductService,private router:Router, private http: HttpClient) { }


  ngOnInit(): void {
    this.addprod = new FormGroup({
      sku:new FormControl("",Validators.required),
      name: new FormControl("",Validators.required),
      description: new FormControl("",Validators.required),
      unitPrice: new FormControl("",Validators.required),
      imageUrl: new FormControl("",Validators.required),
      unitsInStock: new FormControl("",Validators.required),
      categoryName: new FormControl("", Validators.required)
    });
  }






  AddProduct(){
    console.log(this.addprod.value);
    this.addProductService.saveForm(this.addprod.value)
    .subscribe(
      data =>{
      console.log(data);
        if(data){
          alert("Product added successfully");
          this.router.navigate(["admin"]);
        }
        if(data==null){
          alert("Product already exists");
        }
    });
  }   


}
