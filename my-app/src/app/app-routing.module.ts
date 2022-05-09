import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BasicComponent } from './basic/basic.component';
import { CalculatriceComponent } from './basic/calculatrice/calculatrice.component';
import { TvaComponent } from './basic/tva/tva.component';
import { ConvertisseurComponent } from './convertisseur/convertisseur.component';
import { DemoComponent } from './demo/demo.component';
import { DeviseV2Component } from './devise-v2/devise-v2.component';
import { DeviseComponent } from './devise/devise.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
   { path : "basic" , component : BasicComponent  ,
    children: [
      { path: 'tva', component: TvaComponent },
      { path: 'calculatrice/:mode', component: CalculatriceComponent },
      { path: '', redirectTo: 'tva', pathMatch: 'prefix'}
      ]
  } ,
   { path : "demo" , component  : DemoComponent } ,
   { path : "welcome" , component : WelcomeComponent },
   { path : "devise" , component : DeviseComponent },
   { path : "deviseV2" , component : DeviseV2Component },
   { path : "login" , component : LoginComponent },
   { path : "convertisseur" , component : ConvertisseurComponent },
   { path: '', redirectTo: '/welcome', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
