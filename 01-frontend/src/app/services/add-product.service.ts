import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AddProductService {
  private data:any[] = [];
  public set home(home){
    this.data = home;
  }
  public get home(){
    return this.data;
  }
  private host:string = "http://localhost:8080";
  // private addCategoryUrl = 'http://localhost:8080/api/admin/addCategory';
  constructor(private httpClient: HttpClient) { }

  saveForm(home:any){
    const headers= new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');
  console.log(home);
  return this.httpClient.post(`${this.host}/api/admin/product`,home);
  }
}