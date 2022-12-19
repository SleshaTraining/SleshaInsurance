import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class PlandetailsService {

  constructor(private http:HttpClient) { }

  enroll(data:any):Observable<string>{
      return this.http.post(environment.planHost+"/enroll",data,{responseType:'text'})
  }
}
