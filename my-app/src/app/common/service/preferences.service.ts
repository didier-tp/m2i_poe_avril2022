import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PreferencesService {

  //public couleurFond : string = "white"; //valeur par 
  private _couleurFond : string = "white"; //valeur par défaut

  public get couleurFond()  : string { 
    return this._couleurFond;
  }

  public set couleurFond(c:string)  { 
    this._couleurFond=c;
    localStorage.setItem("couleurFond",this._couleurFond);
    //sessionStorage.setItem("couleurFond",this._couleurFond);
  }

  constructor() {
    let c = localStorage.getItem("couleurFond");
    //let c = sessionStorage.getItem("couleurFond");
    this._couleurFond = c?c:'white';
   }
}
