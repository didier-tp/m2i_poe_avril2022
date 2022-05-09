import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-calculatrice',
  templateUrl: './calculatrice.component.html',
  styleUrls: ['./calculatrice.component.scss']
})
export class CalculatriceComponent implements OnInit {

  modeChoisi : "simple" | "sophistiquee" ="simple";

   a /*: number*/ =0;
   b /*: number*/ =0;
   res /*: number*/ =0; 

   onAddition(){
     this.res=Number(this.a) + Number(this.b);
   }

   onSoustraction(){
    this.res=Number(this.a) - Number(this.b);
  }

  onMultiplication(){
    this.res=Number(this.a) * Number(this.b);
  }

  onDivision(){
    this.res=Number(this.a) / Number(this.b);
  }

  constructor(route : ActivatedRoute) { 
    route.params.subscribe(
      (params: Params)=> {
        this.modeChoisi = params['mode'];
      }
    )
    //NB:  { path: 'calculatrice/:mode', ... } dans app-routing.module.ts
  }

  ngOnInit(): void {
  }

}
