import { Component, OnInit } from '@angular/core';
import { Devise } from '../common/data/devise';
import { DeviseService } from '../common/service/devise.service';

@Component({
  selector: 'app-convertisseur',
  templateUrl: './convertisseur.component.html',
  styleUrls: ['./convertisseur.component.scss']
})
export class ConvertisseurComponent implements OnInit {

  tabDevises : Devise[] = [];

  constructor(public deviseService : DeviseService) { 
    //injection de dépendance par constructeur
  }

  ngOnInit(): void {
    this.deviseService.rechercherDevises$()
        .subscribe({ next: (tabDev)=>{ this.tabDevises = tabDev; } ,
                     error: (err)=>{ console.log(err); }
                   });
  }

}
