import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-conversion',
  templateUrl: './conversion.component.html',
  styleUrls: ['./conversion.component.scss']
})
export class ConversionComponent implements OnInit {

  anglesClassiquesDegres = [ 0 , 30, 45 , 60,  90 , 180 , 360];
  anglesClassiquesRadians = [ 0 , Math.PI/6 , Math.PI/ 4, Math.PI / 3, Math.PI / 2 , Math.PI , 2* Math.PI];
  /*
   PI/6 = 30 degres
   PI/4 = 45 degres
   PI/3 = 60 degres
   PI/2 = 90 degres
  */

  angleDegre : number =0;
  angleRadian : number =0;

  aiguOuObtuOuAutre(){
    return {
      angleAigu : this.angleDegre >= 0 && this.angleDegre <90 ,
      angleObtu : this.angleDegre > 90 && this.angleDegre <=180,
      angleDroit : this.angleDegre==90 
    }
  }

  onDegreeToRadian(){
    this.angleRadian = this.angleDegre * Math.PI / 180;
  }

  onRadianToDegre(){
    this.angleDegre = this.angleRadian * 180 / Math.PI ;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
