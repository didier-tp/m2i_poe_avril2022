import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../data/login';
import { LoginResponse } from '../data/loginResponse';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  postLogin$(login :Login): Observable<LoginResponse>{
    //const url = "http://localhost:8282/login-api/public/auth"; // v1 sans ng serve --proxy-config proxy.conf.json
    const url = "login-api/public/auth"; // v2 avec ng serve --proxy-config proxy.conf.json
    /*
    l'appli angular c'est index.html téléchargé en dev depuis http://localhost:4200
    l'url incomplète login-api/public/auth sera alors
    http://localhost:4200/login-api/public/auth (coté navigateur) et donc pas besoin d'autorisation CORS
    et gràce à --proxy-config proxy.conf.json , le serveur démarré via ng serve
    va rediriger les requêtes commençant par login-api vers le serveur http://localhost:8282 .
    */
    return this.http.post<LoginResponse>(url,login /*input envoyé au serveur*/);
    //this.http.post<TypeReponseRetourneParServeur>(url_web_service , donnee_a_envoyer)
  }

  constructor(private http :HttpClient) { 
    //injection de dépendance du service technique HttpClient
  }
}
