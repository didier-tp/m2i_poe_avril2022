import { Component, OnInit } from '@angular/core';
import { Login } from '../common/data/login';
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
    //V1 (sans serveur)
    this.message = "données saisies: " + JSON.stringify(this.login);
    console.log("username="+this.login.username);

    this.sessionService.connecte=true;
    this.sessionService.username=this.login.username;
    //V2: (avec serveur en backend)
  }

  onLogout(){
    this.message = "logout done (no more connected)";
    this.sessionService.connecte=false;
  }

  constructor( public sessionService : SessionService) { }

  ngOnInit(): void {
  }

}
