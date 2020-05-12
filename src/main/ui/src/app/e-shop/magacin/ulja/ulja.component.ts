import { Component } from '@angular/core';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-ulja',
  templateUrl: './ulja.component.html',
  styleUrls: ['./ulja.component.css']
})
export class UljaComponent {
  selectedTab = 0;
  baseUrl = environment.baseUrl;

  slike = {
    motorna_ulja: '/assets/slike/ui/tabovi/mu.png',
    menjacka_ulja: '/assets/slike/ui/tabovi/MEU.png',
    kociona_ulja: '/assets/slike/ui/tabovi/KU.png',
    antifriz: '/assets/slike/ui/tabovi/ANTI.png',
    industrijska_ulja: '/assets/slike/ui/tabovi/INDUSTR.png',
  };
  changeTab(tabIndex: number) {
    this.selectedTab = tabIndex;
  }
}
