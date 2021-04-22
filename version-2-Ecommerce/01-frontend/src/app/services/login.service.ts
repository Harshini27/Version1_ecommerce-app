import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }
  login(userlogin : any)
  {
    return this.httpClient.post("http://localhost:8080/user/login",userlogin,{responseType: 'text' as 'json'});
  }
}
