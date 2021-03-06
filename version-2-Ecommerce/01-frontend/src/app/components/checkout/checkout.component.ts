import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormControl, FormGroup } from '@angular/forms';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  checkoutFormGroup: FormGroup;
  totalPrice: number=0;
  totalQuantity:number=0;
  constructor(private formBuilder: FormBuilder,
    private cartService:CartService ) { }

  ngOnInit(): void {
    this.reviewCartDetails();
    
    this.checkoutFormGroup=this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName:[''],
        lastName:[''],
        email:['']
      })
    });
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
  console.log(this.checkoutFormGroup.get('customer').value);
  }
}
