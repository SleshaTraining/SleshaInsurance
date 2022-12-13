import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SignupService } from './signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm:FormGroup=new FormGroup({});
  constructor(private fb:FormBuilder,private service:SignupService,private router:Router) { }

  ngOnInit(): void {
    this.signupForm=this.fb.group({
      'emailId':['',[Validators.email,Validators.required],null],
      'userName':['',[Validators.required],null],
      'zip':['',[Validators.required],null],
      'dob':['',[Validators.required],null],
      'phone':['',[Validators.required],null],
      'password':['',[Validators.required],null]
    })
  }

  signup(){
    this.service.signUp(this.signupForm.value).subscribe(res=>{
      console.log(res);
      this.router.navigateByUrl('/login')
    },err=>{})
  }

}
