import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PreferencesService {

  public couleurFond : string = "white"; //valeur par défaut

  constructor() { }
}
