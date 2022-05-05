import { Injectable } from '@angular/core';
import { delay, Observable, of } from 'rxjs';
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
      return of(this.tabDevises)
             .pipe( delay(300)); //simuler un temps d'attente de 300ms pour obtenir la réponse
  }

  convertir$(codeDeviseSource:string ,
             codeDeviseCible:string , 
             montant: number ) : Observable<number>{
    //V1 (version simulée sans serveur):
    //return of(1.5); //simulation grossière .
    const deviseSource = this.selectDeviseFromCode(codeDeviseSource);
    const deviseCible = this.selectDeviseFromCode(codeDeviseCible);
    if(deviseSource && deviseCible)
        return of(montant * deviseCible.change / deviseSource.change)
               .pipe( delay(300)); //simuler un temps d'attente de 300ms pour obtenir la réponse
    else return of(0);
  }

  //V1 (version simulée sans serveur)
  tabDevises : Devise[] = [
    new Devise("EUR","Euro",1),
    new Devise("USD","Dollar",1.1),
    new Devise("GBP","Livre",0.9),
    new Devise("JPY","Yen",120)
  ];

  selectDeviseFromCode(codeDevise:string):Devise|null{
    let dev:Devise|null=null;
    for(const d of this.tabDevises){
      if(d.code==codeDevise) dev = d;
    }
    return dev;
  }

  constructor() { }
}
