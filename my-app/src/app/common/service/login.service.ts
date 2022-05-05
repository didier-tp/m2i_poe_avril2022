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
    const url = "http://localhost:8282/login-api/public/auth";
    return this.http.post<LoginResponse>(url,login /*input envoyé au serveur*/);
    //this.http.post<TypeReponseRetourneParServeur>(url_web_service , donnee_a_envoyer)
  }

  constructor(private http :HttpClient) { 
    //injection de dépendance du service technique HttpClient
  }
}
