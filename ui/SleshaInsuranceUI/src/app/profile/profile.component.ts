import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { ProfileService } from './profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  totalCost:number=0;
  constructor(private proService:ProfileService,private apServ:AppService) { }
  plans:any=[];
  ngOnInit(): void {
    this.apServ.userLoggedIn.subscribe(res=>{
      if(res!=''){
        this.proService.getUserPlans(res).subscribe((resp)=>{
          this.plans=resp;
          console.log(this.plans);
          this.totalCost=this.plans.reduce(
            (accumulator:number, currentValue:any) => accumulator + currentValue.plan.averagePremium,
            0
          );
        },err=>{})
      }

    })
    
  }

}
