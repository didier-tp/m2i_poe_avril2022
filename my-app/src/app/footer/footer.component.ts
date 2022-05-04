import { Component, OnInit } from '@angular/core';
import { PreferencesService } from '../common/service/preferences.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  today : Date = new Date();

  tabCouleurs : string[] = [ "white" , "lightgrey" , "lightgreen" , "lightblue"];

  constructor(public preferencesService :PreferencesService ) {
    //injection de dépendance par constructeur de @Component angular
   }

  ngOnInit(): void {
  }

}
