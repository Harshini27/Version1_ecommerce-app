import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators , ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { SignupService } from 'src/app/services/signup.service';



@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signForm: FormGroup;
  constructor(private signUpService: SignupService,private router:Router, private http: HttpClient) { }


  ngOnInit(): void {
    this.signForm = new FormGroup({
      fname:new FormControl("",[Validators.required,Validators.minLength(3)]),
      lname: new FormControl("", [Validators.required,Validators.minLength(3)]),
      email: new FormControl("", [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$") ]),
      password: new FormControl("", [Validators.required,Validators.minLength(6)]),
      address: new FormControl("", [Validators.required, ]),
      mobile: new FormControl("", [Validators.required,Validators.pattern("^((\\+91-?)|0)?[789][0-9]{9}$"), Validators.minLength(10)]),//Validators.pattern('^[0][1-9]\d{9}$|^[1-9]\d{9}$')]),
      gender: new FormControl("", Validators.required),
    });
  }
   
  create(){
    console.log(this.signForm.value);
    this.signUpService.saveForm(this.signForm.value)
    // .subscribe((res:any)=>{
    //   console.log(res);
 
    .subscribe(
      data =>{
      console.log(data);
        if(data){
         
          alert("Registered Successfully");
          this.router.navigate(["login"]);
        }
        if(data==null){
          alert("email already exists");
        }
    });
  }   

}