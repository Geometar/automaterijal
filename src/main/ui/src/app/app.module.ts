import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { StorageServiceModule } from 'angular-webstorage-service';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material/material.module';
import { NavigacijaComponent } from './navigacija/navigacija.component';
import { RobaComponent } from './e-shop/roba/roba.component';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FilteriComponent } from './e-shop/roba/filteri/filteri.component';
import { AkumulatoriComponent } from './e-shop/roba/akumulatori/akumulatori.component';
import { UljaComponent } from './e-shop/roba/ulja/ulja.component';
import { MotornaComponent } from './e-shop/roba/ulja/motorna/motorna.component';
import { MenjackoComponent } from './e-shop/roba/ulja/menjacko/menjacko.component';
import { KocionaComponent } from './e-shop/roba/ulja/kociona/kociona.component';
import { AntifrizComponent } from './e-shop/roba/ulja/antifriz/antifriz.component';
import { IndustrijskaComponent } from './e-shop/roba/ulja/industrijska/industrijska.component';
import { KorpaComponent } from './e-shop/korpa/korpa.component';
import { IzmenaKolicineModalComponent } from './e-shop/korpa/izmena-kolicine-modal/izmena-kolicine-modal.component';
import { LoginComponent } from './e-shop/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { LogoutModalComponent } from './navigacija/logout-modal/logout-modal.component';
import { FakturaComponent } from './e-shop/faktura/faktura.component';
import { TranslatePipe } from './pipes/PrevodilacPipe';
import { EmptyPipe } from './pipes/EmptyPipe';
import { FakturaDetaljiComponent } from './e-shop/faktura/faktura-detalji/faktura-detalji.component';
import { DatePipe } from './pipes/DatePipe';
import { OstaloComponent } from './e-shop/roba/ostalo/ostalo.component';
import { KategorijaSpecificnaComponent } from './e-shop/roba/ostalo/kategorija-specificna/kategorija-specificna.component';
import { PartnerComponent } from './e-shop/partner/partner.component';
import { UspesnoPorucivanjeModalComponent } from './e-shop/korpa/uspesno-porucivanje-modal/uspesno-porucivanje-modal.component';
import { DasboardComponent } from './e-commerce/dasboard/dasboard.component';
import { RegistracijaModalComponent } from './e-shop/login/registracija-modal/registracija-modal.component';
import { ZaboravljenaSifraModalComponent } from './e-shop/login/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component';
import { ResetovanjeSfireComponent } from './e-shop/resetovanje-sfire/resetovanje-sfire.component';
import { KontaktComponent } from './e-commerce/kontakt/kontakt.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigacijaComponent,
    RobaComponent,
    DasboardComponent,
    FilteriComponent,
    AkumulatoriComponent,
    UljaComponent,
    MotornaComponent,
    MenjackoComponent,
    KocionaComponent,
    AntifrizComponent,
    IndustrijskaComponent,
    KorpaComponent,
    IzmenaKolicineModalComponent,
    LoginComponent,
    LogoutModalComponent,
    FakturaComponent,
    TranslatePipe,
    EmptyPipe,
    DatePipe,
    FakturaDetaljiComponent,
    OstaloComponent,
    KategorijaSpecificnaComponent,
    PartnerComponent,
    UspesnoPorucivanjeModalComponent,
    RegistracijaModalComponent,
    ZaboravljenaSifraModalComponent,
    ResetovanjeSfireComponent,
    KontaktComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    ReactiveFormsModule,
    StorageServiceModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    ZaboravljenaSifraModalComponent,
    RegistracijaModalComponent,
    IzmenaKolicineModalComponent,
    LogoutModalComponent,
    UspesnoPorucivanjeModalComponent]
})
export class AppModule { }
