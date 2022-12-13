import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http:HttpClient) { }

  signUp(signupRequest:any){

    return this.http.post(environment.userHost+"/signup",signupRequest,{responseType:'text'})

  }
}
