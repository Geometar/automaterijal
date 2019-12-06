import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { AuthGuard } from './shared/guard/auth-guard';

const routes: Routes = [
  {path: '', redirectTo: '/naslovna', pathMatch: 'full' },
  {path: 'naslovna' , loadChildren: './e-commerce/dasboard/dasboard.module#DasboardModule'},
  {path: 'naslovna/:id', loadChildren: './e-commerce/dasboard/dasboard.module#DasboardModule'},
  {path: 'o-nama' , loadChildren: './e-commerce/o-nama/o-nama.module#ONamaModule'},
  {path: 'kontakt' , loadChildren: './e-commerce/kontakt/kontakt.module#KontaktModule'},
  {path: 'roba' , loadChildren: './e-shop/magacin/roba/roba.module#RobaModule'},
  {path: 'filteri' , loadChildren: './e-shop/magacin/filteri/filteri.module#FilteriModule'},
  {path: 'ulja' , loadChildren: './e-shop/magacin/ulja/ulja.module#UljaModule'},
  {path: 'akumulatori', loadChildren: './e-shop/magacin/akumulatori/akumulatori.module#AkumulatoriModule'},
  {path: 'ostalo' , loadChildren: './e-shop/magacin/ostalo/ostalo.module#OstaloModule'},
  {path: 'ostalo/:id', loadChildren: './e-shop/magacin/ostalo/ostalo.module#OstaloModule'},
  {path: 'login' , loadChildren: './e-shop/login/login.module#LoginModule'},
  {path: 'reset-sifre/:id', loadChildren: './e-shop/resetovanje-sfire/reset-sifre.module#ResetSifreModule'},
  {path: 'licni-podaci' , loadChildren: './e-shop/partner/partner.module#PartnerModule', canActivate: [AuthGuard]},
  {path: 'porudzbenice', loadChildren: './e-shop/faktura/fakture.module#FaktureModule', canActivate: [AuthGuard]},
  {path: 'porudzbenice/:id', loadChildren: './e-shop/faktura/fakture.module#FaktureModule', canActivate: [AuthGuard]},
  {path: 'korpa', loadChildren: './e-shop/korpa/korpa.module#KorpaModule', canActivate: [AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule {}
