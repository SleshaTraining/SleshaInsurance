import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  userLoggedIn:BehaviorSubject<string>= new BehaviorSubject('');

  constructor(private http:HttpClient) { }
}
