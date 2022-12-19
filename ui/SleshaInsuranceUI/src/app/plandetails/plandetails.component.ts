import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { AppService } from '../app.service';
import { PlandetailsService } from './plandetails.service';

@Component({
  selector: 'app-plandetails',
  templateUrl: './plandetails.component.html',
  styleUrls: ['./plandetails.component.css']
})
export class PlandetailsComponent implements OnInit {

  plan:any=null;
  curForm=1;
  basicForm=new FormGroup({});
  advancedForm=new FormGroup({});
  types=['High','Medium','Low']
  msg='';
  constructor(private service:PlandetailsService,private http:HttpClient,private router:ActivatedRoute,private fb:FormBuilder,private apServ:AppService) { }
  
  isLinear = false;
  ngOnInit(): void {
    this.router.params.subscribe(par=>{
      let id=par['id']
      console.log(id)
      this.http.get(environment.planHost+"/"+id).subscribe(res=>{
        console.log(res)
        this.plan=res;
        this.plan.img='../../assets/'+this.plan.planId+'.jpg';
      },err=>{

      })
    
    })

    this.basicForm=this.fb.group({
        'age':['',[Validators.required],null],
        'gender':['',[Validators.required],null],
        'smoke':['',[],null]
    })
    this.advancedForm=this.fb.group({
      'type':['',[Validators.required],null]
    })

  }

  step1(){
    this.curForm+=1;
    if(this.curForm==3){
      this.apServ.userLoggedIn.subscribe(email=>{
          let req:any={}
          req.emailId=email;
          req.age=this.basicForm.value.age;
          req.gender=this.basicForm.value.gender;
          req.smoke=this.basicForm.value.smoke;
          req.type=this.advancedForm.value.type;
          req.planId=this.plan.planId;
          this.service.enroll(req).subscribe(res=>{
            this.msg=res;
          },err=>{})
      })
    }
  }

}
