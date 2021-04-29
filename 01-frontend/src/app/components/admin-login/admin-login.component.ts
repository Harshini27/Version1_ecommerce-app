import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  AdminloginForm: FormGroup;
  emailstore:any;
  constructor(private router : Router) { 
  }

  ngOnInit(): void {
    this.AdminloginForm = new FormGroup({
      email: new FormControl("", Validators.required),
      password :new FormControl("",Validators.required)
    });
  }
  Adminlogin() {
    console.log(this.AdminloginForm.value);
    if(this.AdminloginForm.value.email=="admin" && this.AdminloginForm.value.password=="admin123")
    {
      localStorage.setItem("email",this.AdminloginForm.value.email);
      this.router.navigate(["/admin"]);
    }
    else
    {
      alert("enter valid details");
    }

    
  }
}