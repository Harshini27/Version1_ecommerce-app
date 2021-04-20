import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  // templateUrl: './product-list-table.component.html',
  templateUrl: './product-list-grid.component.html',
  // templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

 products : Product[];
 emailstore:any;
 namestore:any;
  constructor(private productListService : ProductService,public router:Router) { }

  ngOnInit(){
    this.emailstore = localStorage.getItem("email");
    this.namestore=localStorage.getItem("username");
    this.productListService.getProductList().subscribe(
      data => {
        this.products = data;
        console.log(this.products);
      }
    )


  }
  logout(){
    localStorage.clear();
    this.router.navigate(["/login"]);
    
  }

}
