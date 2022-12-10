import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  now:Date=new Date();
  offerLeft=''
  ngOnInit(){
    let x=new Date(2023,0,1);
    this.offerLeft=Math.ceil((x.getTime()-this.now.getTime())/(1000 * 3600 *24))+' Days';
  }

}
