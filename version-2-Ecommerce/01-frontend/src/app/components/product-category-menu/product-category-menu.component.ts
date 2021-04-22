import { Component, OnInit } from '@angular/core';
import { ProductCategory } from 'src/app/common/product-category';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-product-category-menu',
  templateUrl: './product-category-menu.component.html',
  styleUrls: ['./product-category-menu.component.css']
})
export class ProductCategoryMenuComponent implements OnInit {

  productCategories: ProductCategory[];
  emailstore:any;
  namestore:any;
  constructor(private productCategoryService: ProductService,public router : Router) { }

  ngOnInit() {
    this.emailstore = localStorage.getItem("email");
    this.namestore=localStorage.getItem("username");
    this.productCategoryService.getProductCategories().subscribe(
      data => {
        
        console.log(JSON.stringify(data));
        this.productCategories = data;
        console.log(this.productCategories);
      }
    );    
  }
  logout(){
    localStorage.clear();
    this.router.navigate(["/login"]);
    
  }
}
