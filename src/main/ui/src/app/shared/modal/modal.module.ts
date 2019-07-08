import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ZaboravljenaSifraModalComponent } from './zaboravljena-sifra-modal/zaboravljena-sifra-modal.component';
import { RegistracijaModalComponent } from './registracija-modal/registracija-modal.component';
import { IzmenaKolicineModalComponent } from './izmena-kolicine-modal/izmena-kolicine-modal.component';
import { LogoutModalComponent } from './logout-modal/logout-modal.component';
import { UspesnoPorucivanjeModalComponent } from './uspesno-porucivanje-modal/uspesno-porucivanje-modal.component';
import { NeuspesnoPorucivanjeModalComponent } from './neuspesno-porucivanje-modal/neuspesno-porucivanje-modal.component';
import { PorukaModalComponent } from './poruka-modal/poruka-modal.component';
import { BrendoviModalComponent } from './brendovi-modal/brendovi-modal.component';
import { UpitModalComponent } from './upit-modal/upit-modal.component';
import { SesijaIsteklaModalComponent } from './sesija-istekla-modal/sesija-istekla-modal.component';
import { PrvoLogovanjeModalComponent } from './prvo-logovanje-modal/prvo-logovanje-modal.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material.module';
import { SharedMagacinModule } from 'src/app/e-shop/magacin/shared-components/shared-magacin.module';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule,
    SharedMagacinModule,
  ],
  declarations: [
    ZaboravljenaSifraModalComponent,
    RegistracijaModalComponent,
    IzmenaKolicineModalComponent,
    LogoutModalComponent,
    UspesnoPorucivanjeModalComponent,
    NeuspesnoPorucivanjeModalComponent,
    PorukaModalComponent,
    BrendoviModalComponent,
    UpitModalComponent,
    SesijaIsteklaModalComponent,
    PrvoLogovanjeModalComponent],
  entryComponents: [
    ZaboravljenaSifraModalComponent,
    RegistracijaModalComponent,
    IzmenaKolicineModalComponent,
    LogoutModalComponent,
    UspesnoPorucivanjeModalComponent,
    NeuspesnoPorucivanjeModalComponent,
    PorukaModalComponent,
    BrendoviModalComponent,
    UpitModalComponent,
    SesijaIsteklaModalComponent,
    PrvoLogovanjeModalComponent]
  })
export class ModalModule { }
