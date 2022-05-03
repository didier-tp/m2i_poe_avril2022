import { Component, OnInit } from '@angular/core';
import { Devise } from '../common/data/devise';

@Component({
  selector: 'app-devise',
  templateUrl: './devise.component.html',
  styleUrls: ['./devise.component.scss']
})
export class DeviseComponent implements OnInit {

  //tabDevises de type Devise[]

  //selectedDevise de type Devise | undefined

  //message de type string (= "")

  //fonction évenementielle à appeler lorsque l'on
  //va sélectionner une des lignes du tableau
  onSelectDevise(Devise d){
      //mettre à jour this.selectedDevise
      // et this.message JSON.stringify(this.selectedDevise)
  }

  constructor() {
    //V1 (sans backend), avec des valeurs simulées en mémoire
    this.tabDevises.push(new Devise("EUR","Euro",1));
    this.tabDevises.push(new Devise("USD","Dolar",1.1));
    this.tabDevises.push(new Devise("GBP","Livre",0.9));
    this.tabDevises.push(new Devise("JPY","Yen",120));
   }

  ngOnInit(): void {
  }

}
