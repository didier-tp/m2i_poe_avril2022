import { Component, OnInit } from '@angular/core';
import { Devise } from '../common/data/devise';
import { DeviseService } from '../common/service/devise.service';

@Component({
  selector: 'app-devise-v2',
  templateUrl: './devise-v2.component.html',
  styleUrls: ['./devise-v2.component.scss']
})
export class DeviseV2Component implements OnInit {

  cloneDevise(d:Devise){
    return JSON.parse(JSON.stringify(d));
  }

  tabDevises : Devise[] = [];

  selectedDevise : Devise | undefined;

  //[(ngModel)]="deviseTemp.code" , ....
  deviseTemp : Devise = new Devise();

  message /*: string*/ ="";

  mode : "newOne" | "existingOne" = "newOne";

  onNew(){
    this.mode="newOne";
    this.selectedDevise=undefined;
    this.deviseTemp = new Devise();
  }

  onAdd(){
    this.deviseService.postDevise$(this.deviseTemp)
    .subscribe(
     { next: (savedDevise)=>{ this.message="devise ajoutée";
                   this.addClientSide(savedDevise); } ,
      error: (err)=>{ this.message="echec post"
                     console.log(err); }
   });
  }

  addClientSide(savedDevise:Devise){
    this.tabDevises.push(savedDevise);
    this.onNew();
  }

  onDelete(){
    if(this.selectedDevise){
         this.deviseService.deleteDevise$(this.selectedDevise.code)
             .subscribe(
              { next: ()=>{ this.message="devise bien supprimée";
                            this.deleteClientSide(); } ,
               error: (err)=>{ this.message="echec suppression"
                              console.log(err); }
            });
    }
  }

  deleteClientSide(){
    if(this.selectedDevise){
      let indexToDelete = -1;
      this.tabDevises.forEach((devise,index)=>{if(devise==this.selectedDevise) indexToDelete=index; });
      if(indexToDelete>=0){
        this.tabDevises.splice(indexToDelete,1);
      }
    }
    this.onNew();
  }

  onUpdate(){
    this.deviseService.putDevise$(this.deviseTemp)
    .subscribe(
     { next: (updatedDevise)=>{ this.message="devise bien mise à jour";
                   this.updateClientSide(updatedDevise); } ,
      error: (err)=>{ this.message="echec update (put)"
                     console.log(err); }
   });
  }

  updateClientSide(updatedDevise:Devise){
    //test imposé par typescript sur this.selectedDevise potentiellement undefined
     if(this.selectedDevise != undefined){
      //Rappel: this.selectedDevise est ici une référence
      //qui pointe directement sur le i eme objet du tableau this.tabDevises
      //(selon ligne sélectionnée)
           this.selectedDevise.code = updatedDevise.code;
           this.selectedDevise.name = updatedDevise.name;
           this.selectedDevise.change = updatedDevise.change;
     }
    }

  //fonction évenementielle à appeler lorsque l'on
  //va sélectionner une des lignes du tableau
  onSelectDevise(d : Devise , i : number){
    //NB: d:Devise est passé par référence (comportement de java/javascript)
    //et donc ici d et this.selectedDevise référencent
    //directement un des objets du tableau this.tabDevises
    console.log("indice de la devise selectionnee=" + i);
      this.selectedDevise = d;
      this.mode="existingOne";
      //via un clonage explicite , this.deviseTemp est une copie
      //indépendante de this.selectedDevise (et pas une référence sur l'objet original)
      this.deviseTemp = this.cloneDevise(this.selectedDevise);
      this.message = "devise selectionnée = " + JSON.stringify(this.selectedDevise);
  }

  constructor(private deviseService : DeviseService) {
    //injection de dépendance via constructeur
    //V2 (avec backend)
   }

   ngOnInit(): void {
    this.deviseService.rechercherDevises$()
        .subscribe({ next: (tabDev)=>{ /*this.tabDevises = tabDev;*/
                                       this.initAfterFetch(tabDev) } ,
                     error: (err)=>{ console.log(err); }
                   });
  }

  initAfterFetch(tabDev:Devise[]){
    this.tabDevises = tabDev;
  }

}
