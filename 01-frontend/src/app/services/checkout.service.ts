import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Purchase } from '../common/purchase';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private purchaseUrl = 'http://localhost:8080/api/checkout/purchase';

  constructor(private httpClient: HttpClient) { }

  placeOrder(purchase: Purchase): Observable<any> {
    console.log(purchase);
    if(purchase.order.totalPrice!=0 && purchase.order.totalQuantity!=0)
    {
      return this.httpClient.post<Purchase>(this.purchaseUrl, purchase); 
    }
    else
    {
      alert(`you dont have any orders to purchase`);
    }
       
  }
  
}