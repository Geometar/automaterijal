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
    motorna_ulja: this.baseUrl + '/assets/slike/ui/tabovi/mu.png',
    menjacka_ulja: this.baseUrl + '/assets/slike/ui/tabovi/MEU.png',
    kociona_ulja: this.baseUrl + '/assets/slike/ui/tabovi/KU.png',
    antifriz: this.baseUrl + '/assets/slike/ui/tabovi/ANTI.png',
    industrijska_ulja: this.baseUrl + '/assets/slike/ui/tabovi/INDUSTR.png',
  };
  changeTab(tabIndex: number) {
    this.selectedTab = tabIndex;
  }
}
