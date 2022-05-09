import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';

import { BasicComponent } from './basic/basic.component';
import { CalculatriceComponent } from './basic/calculatrice/calculatrice.component';
import { TvaComponent } from './basic/tva/tva.component';
import { FooterComponent } from './footer/footer.component';
import { FormsModule } from '@angular/forms';
import { ConversionComponent } from './basic/conversion/conversion.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { DeviseComponent } from './devise/devise.component';
import { LoginComponent } from './login/login.component';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { TogglePanelComponent } from './toggle-panel/toggle-panel.component';
import { ConvertisseurComponent } from './convertisseur/convertisseur.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { DeviseV2Component } from './devise-v2/devise-v2.component';
import { ZzComponent } from './demo/zz/zz.component';
import { ListProdComponent } from './demo/list-prod/list-prod.component';
import { SeuilComponent } from './demo/seuil/seuil.component';
import { RegletteComponent } from './demo/reglette/reglette.component';
import { DemoComponent } from './demo/demo.component';
import { MyAuthInterceptor } from './common/my-auth.interceptor';
import { NotAuthorizedComponent } from './not-authorized/not-authorized.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BasicComponent,
    CalculatriceComponent,
    TvaComponent,
    ConversionComponent,
    WelcomeComponent,
    DeviseComponent,
    LoginComponent,
    TogglePanelComponent,
    ConvertisseurComponent,
    DeviseV2Component,
    ZzComponent,
    SeuilComponent,
    ListProdComponent,
    RegletteComponent,
    DemoComponent,
    NotAuthorizedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    TabsModule.forRoot(),
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: MyAuthInterceptor,
      multi: true
      } 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
