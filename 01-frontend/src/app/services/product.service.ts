import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import {Product} from '../common/product';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';
import { ProductCategory } from '../common/product-category';



@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl='http://localhost:8080/api/products';
  // private categoryUrl = 'http://localhost:8080/categories';

  constructor(private httpClient: HttpClient) { }

  getProduct(theProductId: number) : Observable<Product>{
    const productUrl = `${this.baseUrl}/${theProductId}`;
    return this.httpClient.get<Product>(productUrl);
    
  }
  // getCategory(theCategoryId:number):Observable<ProductCategory>{
  //   const productCategoryUrl = `${this.categoryUrl}/${theCategoryId}`;
  //   return this.httpClient.get<ProductCategory>(productCategoryUrl);
  // }

  getProducts() : Observable<Product[]>{
    // const productCategoryUrl = `${this.categoryUrl}/${theCategoryId}`;
    return this.httpClient.get<Product[]>(this.baseUrl);
  }
  getProductList(theCategoryId:number) : Observable<Product[]>{
    if(theCategoryId!=null)
    {
        const productCategoryUrl = `${this.baseUrl}/categories/${theCategoryId}`;
        return this.httpClient.get<Product[]>(productCategoryUrl);

    }
    else{
          return this.httpClient.get<Product[]>(this.baseUrl);
           
    }
  }


  getProductCategories(): Observable<ProductCategory[]> {
   const categoryUrl=`${this.baseUrl}/categories`
    return this.httpClient.get<ProductCategory[]>(categoryUrl);
  }

}
