import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../common/data/login';
import { LoginResponse } from '../common/data/loginResponse';
import { LoginService } from '../common/service/login.service';
import { SessionService } from '../common/service/session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  //objet de données pour recueillir les valeurs saisies
  login : Login = new Login();

  message /*: string*/ =""; 

  onLogin(){
    /*
    //V1 (sans serveur)
    this.message = "données saisies: " + JSON.stringify(this.login);
    console.log("username="+this.login.username);
    
    this.sessionService.connecte=true;
    this.sessionService.username=this.login.username;
    */
    //V2: (avec serveur en backend)
    this.loginService.postLogin$(this.login)
        .subscribe(
          { next: (loginResponse)=>{ this.gererReponseLogin(loginResponse); } ,
            error: (err)=>{ console.log(err); }
          });
  }

  gererReponseLogin(loginResponse:LoginResponse){
    this.message=loginResponse.message;
    console.log("loginResponse= "+ JSON.stringify(loginResponse));
    this.sessionService.connecte=loginResponse.status;
    if(loginResponse.status){
      sessionStorage.setItem("token",loginResponse.token?loginResponse.token:"null");
      this.sessionService.username=loginResponse.username;
    }else{
      sessionStorage.setItem("token","null");
    }
  }

  onNavigate(){
    /*une fois avoir ajouté _router dans les injections de dépendances 
    (du constructeur de cette classe).
    On va déclencher ici (par programmation)
    une navigation vers /deviseV2
    */
    const link= ["/deviseV2"];
    if(this.sessionService.connecte){
       this._router.navigate(link);
      //ou bien this._router.navigateByUrl("/deviseV2");
    }else{
      this.message="pas de login, pas de deviseV2"
    }
  }

  onLogout(){
    this.message = "logout done (no more connected)";
    this.sessionService.connecte=false;
    sessionStorage.setItem("token","null");
  }

  constructor( public sessionService : SessionService,
               public loginService : LoginService,
               private _router : Router) { }

  ngOnInit(): void {
  }

}
