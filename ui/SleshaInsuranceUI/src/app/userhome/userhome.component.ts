import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { UserhomeService } from './userhome.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {

  constructor(private service:UserhomeService,private apService:AppService,private router:Router) { }
  plans:any=[];
  ngOnInit(): void {
    this.service.getPlans().subscribe(res=>{
      this.plans=res;
      
      this.plans.forEach((x:any)=>{
        let img=""
        x.planName.split(" ").forEach((x:string)=>{img+=x.substring(0,2)});
        
        x.img="../../assets/"+img+'.jpg';});
    })
    this.apService.userLoggedIn.subscribe(res=>{
      if(res==''){
        this.router.navigateByUrl('/');
      }
    })
  }

}
