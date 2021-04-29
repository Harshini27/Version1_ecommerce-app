import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {
  cartItems: CartItem[]=[];
  totalPrice: number=0;
  totalQuantity: number=0;
  emailstore:any;
  namestore:any;

  constructor(private cartService: CartService,public router:Router) { }

  ngOnInit(): void {
    this.listCartDetails();
    this.emailstore = localStorage.getItem("email");
    this.namestore=localStorage.getItem("username");
  }
  listCartDetails() {
   this.cartItems=this.cartService.cartItems;
   this.cartService.totalPrice.subscribe(
     data=>this.totalPrice=data
   );
    this.cartService.totalQuantity.subscribe(
      data=>this.totalQuantity=data
    );
    this.cartService.computeCartTotals();

  }
  incrementQuantity(theCartItem: CartItem){
    this.cartService.addToCart(theCartItem);
  }
  decrementQuantity(theCartItem:CartItem){
    this.cartService.decrementQuantity(theCartItem)
  }
  remove(theCartItem: CartItem){
    this.cartService.remove(theCartItem);
  }
  logout(){
    localStorage.clear();
    this.router.navigate(["/login"]);
    
  }

  
}
