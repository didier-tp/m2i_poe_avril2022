import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Devise } from '../data/devise';

@Injectable({
  providedIn: 'root'
})
export class DeviseService {
  //$ en fin de nom de fonction
  //= convention facultative de nom de fonction
  //pour dire que ça retourne un Observable
  rechercherDevises$() : Observable< Devise[]> {
      //V1:
      return of(this.tabDevises);
  }

  convertir$(codeDeviseSource:string ,
             codeDeviseCible:string , 
             montant: number ) : Observable<number>{
  //V1 (version simulée sans serveur):
  return of(1.5); //simulation grossière .
  }

  //V1 (version simulée sans serveur)
  tabDevises : Devise[] = [
    new Devise("EUR","Euro",1),
    new Devise("USD","Dollar",1.1),
    new Devise("GBP","Livre",0.9),
    new Devise("JPY","Yen",120)
  ];

  constructor() { }
}
