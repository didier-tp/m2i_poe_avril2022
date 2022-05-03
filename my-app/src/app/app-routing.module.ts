import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BasicComponent } from './basic/basic.component';
import { DeviseComponent } from './devise/devise.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
   { path : "basic" , component : BasicComponent } ,
   { path : "welcome" , component : WelcomeComponent },
   { path : "devise" , component : DeviseComponent },
   { path: '', redirectTo: '/welcome', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
