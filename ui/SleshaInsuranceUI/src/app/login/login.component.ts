import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm:FormGroup=new FormGroup({});
  constructor(private fb:FormBuilder,private service:LoginService,private router:Router) { }

  ngOnInit(): void {
    this.loginForm=this.fb.group({
      'emailId':['',[Validators.required,Validators.email],null],
      'password':['',[Validators.required],null]
    });
  }

  login(){
    console.log(this.loginForm.value);
    this.service.login(this.loginForm.value).subscribe(res=>{
      this.router.navigateByUrl('/userHome');
    },err=>{});

  }

}
