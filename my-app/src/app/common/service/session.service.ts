import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  
  private _connecte /*: boolean*/ = false;
  public get connecte(){ return this._connecte; }
  public set connecte(c:boolean){ 
    this._connecte=c;
    sessionStorage.setItem("session.connecte",this._connecte.toString()); }

  private _username /*: string*/ = "powerUser";
  public get username(){ return this._username; }
  public set username(u:string){ 
    this._username=u;
    sessionStorage.setItem("session.username",this._username); }

  constructor() { 
    const estConnecte= sessionStorage.getItem("session.connecte");
    if(estConnecte=="true")
         this._connecte = true;
    else  this._connecte = false;

    const u = sessionStorage.getItem("session.username");
    this._username = u?u:'?';
  }
}
