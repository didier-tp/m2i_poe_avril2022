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
  deviseSource : Devise | undefined;
  deviseCible : Devise | undefined;
  montant /*: number*/ = 0;
  montantConverti /*: number*/ = 0;

  constructor(public deviseService : DeviseService) { 
    //injection de dépendance par constructeur
  }

  onConvertir(){
    if(this.deviseSource == undefined || this.deviseCible == undefined) return;
    this.deviseService.convertir$(this.deviseSource.code ,
                                  this.deviseCible.code,this.montant)
                      .subscribe({ next: (resConv)=>{ this.montantConverti = resConv; } ,
                                  error: (err)=>{ console.log(err); }
                                });
  }

  ngOnInit(): void {
    this.deviseService.rechercherDevises$()
        .subscribe({ next: (tabDev)=>{ this.tabDevises = tabDev; } ,
                     error: (err)=>{ console.log(err); }
                   });
  }

}
