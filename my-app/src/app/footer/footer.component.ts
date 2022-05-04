import { Component, OnInit } from '@angular/core';
import { PreferencesService } from '../common/service/preferences.service';
import { SessionService } from '../common/service/session.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  today : Date = new Date();

  tabCouleurs : string[] = [ "white" , "lightgrey" , "lightgreen" , "lightblue"];

  constructor(public preferencesService :PreferencesService ,
              public sessionService : SessionService) {
    //injection de dépendance par constructeur de @Component angular
   }

  ngOnInit(): void {
  }

}
