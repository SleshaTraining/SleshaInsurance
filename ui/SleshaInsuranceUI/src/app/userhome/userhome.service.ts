import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class UserhomeService {

  constructor(private http:HttpClient) { }

  getPlans(){
    return this.http.get(environment.planHost);
  }
}
