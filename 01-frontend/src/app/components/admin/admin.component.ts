import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  emailstore:any;
  constructor(public router:Router) { }

  ngOnInit(): void {

    this.emailstore = localStorage.getItem("email");
  }
  logout(){
    localStorage.clear();
    this.router.navigate(["/products"]);
    
  }

}
