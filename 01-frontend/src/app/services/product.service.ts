import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import {Product} from '../common/product';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl='http://localhost:8080/api/products';

  constructor(private httpClient: HttpClient) { }

  getProduct(theProductId: number) : Observable<Product>{
    const productUrl = `${this.baseUrl}/${theProductId}`;
    return this.httpClient.get<Product>(productUrl);
    
  }

  getProductList() : Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.baseUrl);
  }
}
