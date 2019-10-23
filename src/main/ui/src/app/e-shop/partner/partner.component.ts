import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Partner } from '../model/dto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-partner',
  templateUrl: './partner.component.html',
  styleUrls: ['./partner.component.scss']
})
export class PartnerComponent implements OnInit {

  public partner: Partner;
  public daLiDuguje = false;
  public korisnickoImeMetod = 'novo';
  public losaSifra = false;
  public korisnickoImeJeZauzeto = false;

  public ucitavanje = false;


  constructor(
    private loginServis: LoginService) { }

  ngOnInit() {
    this.loginServis.izbaciPartneraIzSesiseAkoJeUMemoriji();
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.daLiDuguje = this.partner.stanje < 0;
  }
}
