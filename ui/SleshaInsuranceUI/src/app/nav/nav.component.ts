import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(private apServ:AppService) { }
  loggedIn:Boolean=false;
  ngOnInit(): void {

    this.apServ.userLoggedIn.subscribe(res=>{
      if(res!=''){
        this.loggedIn=true;
      }
    })
  }

}
