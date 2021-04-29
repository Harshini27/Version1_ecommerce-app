import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import {Router,ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-cart-status',
  templateUrl: './cart-status.component.html',
  styleUrls: ['./cart-status.component.css']
})
export class CartStatusComponent implements OnInit {
  totalPrice: number=0.00;
  totalQuantity: number=0;
  emailstore:any;
  namestore:any;
  constructor(private cartService:CartService,public router:Router) { }

  ngOnInit(): void {
    this.updateCartStatus();
    this.emailstore = localStorage.getItem("email");
    this.namestore=localStorage.getItem("username");
  }
  updateCartStatus() {
    this.cartService.totalPrice.subscribe(
      data=>this.totalPrice=data
    );
    this.cartService.totalQuantity.subscribe(
      data=>this.totalQuantity=data
    );
  }
  logout(){
    localStorage.clear();
    this.router.navigate(["/login"]);
    
  }

}
