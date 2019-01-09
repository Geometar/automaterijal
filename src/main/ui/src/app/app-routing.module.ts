import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { FilteriComponent } from './e-shop/roba/filteri/filteri.component';
import { AkumulatoriComponent } from './e-shop/roba/akumulatori/akumulatori.component';
import { UljaComponent } from './e-shop/roba/ulja/ulja.component';
import { KorpaComponent } from './e-shop/korpa/korpa.component';
import { LoginComponent } from './e-shop/login/login.component';
import { FakturaComponent } from './e-shop/faktura/faktura.component';
import { FakturaDetaljiComponent } from './e-shop/faktura/faktura-detalji/faktura-detalji.component';
import { OstaloComponent } from './e-shop/roba/ostalo/ostalo.component';
import { KategorijaSpecificnaComponent } from './e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component';
import { PartnerComponent } from './e-shop/partner/partner.component';
import { RobaComponent } from './e-shop/roba/roba.component';
import { DasboardComponent } from './e-commerce/dasboard/dasboard.component';

const routes: Routes = [
  {path: '', redirectTo: '/naslovna', pathMatch: 'full' },
  {path: 'naslovna' , component: DasboardComponent},
  {path: 'o-nama' , component: DasboardComponent},
  {path: 'kontakt' , component: DasboardComponent},
  {path: 'roba' , component: RobaComponent},
  {path: 'filteri' , component: FilteriComponent},
  {path: 'ulja' , component: UljaComponent},
  {path: 'akumulatori' , component: AkumulatoriComponent},
  {path: 'ostalo' , component: OstaloComponent},
  {path: 'ostalo/:id', component: KategorijaSpecificnaComponent},
  {path: 'login' , component: LoginComponent},
  {path: 'kontakt' , component: DasboardComponent},
  {path: 'licni-podaci' , component: PartnerComponent},
  {path: 'porudzbenice', component: FakturaComponent},
  {path: 'porudzbenice/:id', component: FakturaDetaljiComponent},
  {path: 'korpa', component: KorpaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
