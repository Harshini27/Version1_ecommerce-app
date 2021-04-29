import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Order } from 'src/app/common/order';
import { OrderItem } from 'src/app/common/order-item';
import { Purchase } from 'src/app/common/purchase';
import { User } from 'src/app/common/user';
import { CartService } from 'src/app/services/cart.service';
import { CheckoutService } from 'src/app/services/checkout.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  // checkoutFormGroup: FormGroup;
  totalPrice: number=0;
  totalQuantity:number=0;
  emailstore:any;
   
  constructor(private cartService:CartService ,private checkoutService:CheckoutService,private router:Router) { }

  ngOnInit(): void {
    this.emailstore= localStorage.getItem("email");
    this.reviewCartDetails();
    // this.checkoutFormGroup =new FormGroup();
  }
  reviewCartDetails() {
    this.cartService.totalQuantity.subscribe(
      totalQuantity=>this.totalQuantity=totalQuantity
    );
    this.cartService.totalPrice.subscribe(
     totalPrice=>this.totalPrice=totalPrice 
    );
  }
onSubmit(){
  console.log("Handling submit button");
  //set up order
  let order=new Order();
  order.totalPrice=this.totalPrice;
  order.totalQuantity=this.totalQuantity;


  let user=new User();
  user.email=this.emailstore;


  //get cart items
  const cartItems=this.cartService.cartItems;
  ///cretae orderItems from cartItems
  // let orderItems:OrderItem[]=[];
  // for(let i=0;i<cartItems.length;i++)
  // {
  //   orderItems[i]=new OrderItem(cartItems[i]);
  // }
  let orderItems:OrderItem[]=cartItems.map(tempCartItem=>new OrderItem(tempCartItem));

  //set up purchase
  let purchase=new Purchase();

 //populate purchase - order and orderItems
     purchase.user=user;
     purchase.order=order;
     purchase.orderItems=orderItems;
     console.log(purchase);


//calling rest API
this.checkoutService.placeOrder(purchase).subscribe(
  {
    next:response =>{
      alert(`your order has been recieved.\nOrder tracking number:${response.orderTrackingNumber}`);
      this.resetCart();
    },
    error:err => {
      alert(`there was an error:${err.message}`);
    }
  }
);

}
  resetCart() {
    this.cartService.cartItems=[];
    this.cartService.totalPrice.next(0);
    this.cartService.totalQuantity.next(0);
    this.router.navigateByUrl("/products");
  
 }
}
