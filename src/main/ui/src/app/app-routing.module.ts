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
import { ResetovanjeSfireComponent } from './e-shop/resetovanje-sfire/resetovanje-sfire.component';
import { KontaktComponent } from './e-commerce/kontakt/kontakt.component';
import { ONamaComponent } from './e-commerce/o-nama/o-nama.component';
import { VestiComponent } from './e-commerce/dasboard/vesti/vesti.component';

const routes: Routes = [
  {path: '', redirectTo: '/naslovna', pathMatch: 'full' },
  {path: 'naslovna' , component: DasboardComponent},
  {path: 'o-nama' , component: ONamaComponent},
  {path: 'kontakt' , component: KontaktComponent},
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
  {path: 'naslovna/:id', component: VestiComponent},
  {path: 'korpa', component: KorpaComponent},
  {path: 'reset-sifre/:id', component: ResetovanjeSfireComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule {}
