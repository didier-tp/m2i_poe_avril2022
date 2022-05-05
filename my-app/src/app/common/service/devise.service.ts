import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, map, Observable, of } from 'rxjs';
import { Devise } from '../data/devise';

class ResultatConversion{
  constructor(
       public source : string ="",
       public target : string ="",
       public amount : number =0,
       public result : number =0,
  ){}
}


@Injectable({
  providedIn: 'root'
})
export class DeviseService {
  //$ en fin de nom de fonction
  //= convention facultative de nom de fonction
  //pour dire que ça retourne un Observable
  rechercherDevises$() : Observable< Devise[]> {
      const url = "http://localhost:8282/devise-api/public/devise";
      return this.http.get<Devise[]>(url);
  }

  /*
  serveur backend-tp-api
  a URL
  http://localhost:8282/devise-api/public/convert?source=EUR&target=USD&amount=200
  renvoyant
  {"source":"EUR","target":"USD","amount":200,"result":217.39130434782606}
  */

  convertir$(codeDeviseSource:string ,
             codeDeviseCible:string , 
             montant: number ) : Observable<number>{
    const url = `http://localhost:8282/devise-api/public/convert`
         + `?source=${codeDeviseSource}&target=${codeDeviseCible}&amount=${montant}`;
    return this.http.get<ResultatConversion>(url)
               .pipe(
                   map((respServer :ResultatConversion)=>respServer.result)
               );
  }

  

  constructor(private http :HttpClient) { 
    //injection de dépendance du service technique HttpClient
    //dans notre service fonctionnel deviseService
  }
}
