import { Component, OnInit } from '@angular/core';
import {Router,ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import { CartService } from 'src/app/services/cart.service';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

 products : Product[];
 currentCategoryId:number;
 totalPrice: number=0.00;
 totalQuantity: number=0;
 emailstore:any;
 namestore:any;
 cart_items:any;

  constructor(private productListService : ProductService,public router:Router,private route : ActivatedRoute,
    private cartService: CartService) { }

  ngOnInit(){
    this.emailstore = localStorage.getItem("email");
    this.namestore=localStorage.getItem("username");
    this.route.paramMap.subscribe(()=>{
      this.ProductList();
      this.updateCartStatus();
    });

  }
  logout(){
    localStorage.clear();
    this.router.navigate(["/login"]);
    
  }
  ProductList()
  {
    const hasCategoryId :boolean=this.route.snapshot.paramMap.has('id');
    if(hasCategoryId)
    {
      this.currentCategoryId=+this.route.snapshot.paramMap.get('id');
      console.log(this.currentCategoryId);
    }
    else
    {
      this.currentCategoryId=null;
    }

    this.productListService.getProductList(this.currentCategoryId).subscribe(
      data => {
        console.log(data);
        this.products = data;
      })

  }
  addToCart(theProduct: Product){
    console.log('Adding to cart: ${theProduct.name},${theProduct.unitPrice}');
    this.cart_items=theProduct;
    localStorage.setItem("product",this.cart_items);
    const theCartItem=new CartItem(theProduct);
    this.cartService.addToCart(theCartItem);
    console.log(localStorage.getItem(this.cart_items.id));
  }
  updateCartStatus() {
    this.cartService.totalPrice.subscribe(
      data=>this.totalPrice=data
    );
    this.cartService.totalQuantity.subscribe(
      data=>this.totalQuantity=data
    );
  }

}
