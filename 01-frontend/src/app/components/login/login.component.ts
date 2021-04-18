import { Component, OnInit } from '@angular/core';
import {  EmailValidator, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  userdetails : any;
  items :any;
  constructor(private loginservice : LoginService,private router : Router) { 
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl("", [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$") ]),
      password :new FormControl("",Validators.required)
    });
  }
  login() {
    console.log(this.loginForm.value);
    this.loginservice.login(this.loginForm.value)
    .subscribe(
      data =>{
      console.log(data);
        if(data!=''){
      console.log("login successful");  
      console.log(data);
      this.userdetails=data;
      this.items=JSON.parse(this.userdetails);
      localStorage.setItem("email",this.items.email);
      localStorage.setItem("username",this.items.fname);
      console.log(this.items.email);

          alert("login successful");
          this.router.navigate(["/home"]);
        }
        if(data==null){
          alert("username or password is wrong");
        }
    });
  }
}