import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculatrice',
  templateUrl: './calculatrice.component.html',
  styleUrls: ['./calculatrice.component.scss']
})
export class CalculatriceComponent implements OnInit {

   a /*: number*/ =0;
   b /*: number*/ =0;
   res /*: number*/ =0; 

   onAddition(){
     this.res=Number(this.a) + Number(this.b);
   }

   onSoustraction(){
    this.res=Number(this.a) - Number(this.b);
  }

  constructor() { }

  ngOnInit(): void {
  }

}
