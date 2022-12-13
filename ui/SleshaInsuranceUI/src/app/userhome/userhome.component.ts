import { Component, OnInit } from '@angular/core';
import { UserhomeService } from './userhome.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {

  constructor(private service:UserhomeService) { }
  plans:any=[];
  ngOnInit(): void {
    this.service.getPlans().subscribe(res=>{
      this.plans=res;
      this.plans.forEach((x:any)=>{x.img="../../assets/"+x.planId+'.jpg'});
    })
  }

}
