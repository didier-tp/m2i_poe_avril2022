import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'toggle-panel',
  templateUrl: './toggle-panel.component.html',
  styleUrls: ['./toggle-panel.component.scss']
})
export class TogglePanelComponent implements OnInit {

  @Input()
  titre /*:string*/ ="titreParDefaut"

  toggleP /*:boolean*/ = false;

  constructor() { }

  ngOnInit(): void {
  }

}
