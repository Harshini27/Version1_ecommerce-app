import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  emailstore:any;
  constructor(public router:Router){}
  ngOnInit(): void {
    this.emailstore = localStorage.getItem("email");
    console.log(this.emailstore);
   
  }
  title = 'angular-ecommerce';

  logout(){
    localStorage.clear();
    this.router.navigate(["/login"]);
    
  }
}


