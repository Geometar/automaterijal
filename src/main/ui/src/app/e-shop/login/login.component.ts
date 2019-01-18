import { Component, OnInit } from '@angular/core';
import { Credentials, Partner } from '../model/dto';
import { LoginService } from '../service/login.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { RegistracijaModalComponent } from './registracija-modal/registracija-modal.component';
import { ZaboravljenaSifraModalComponent } from './zaboravljena-sifra-modal/zaboravljena-sifra-modal.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public registerForm: FormGroup;
  public submitted = false;
  public credentials: Credentials = {};
  public partner: Partner;
  public uspesnoLogovanje = true;

  constructor(
    private loginServis: LoginService,
    private formBuilder: FormBuilder,
    public dialog: MatDialog) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  login() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }
    this.loginServis.ulogujSe(this.credentials);
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.loginServis.daLiJeLogovanjeUspesno.subscribe(b => this.uspesnoLogovanje = b);
  }

  otvoriResgracijaDialog() {
    const dialogRef = this.dialog.open(RegistracijaModalComponent, {
      width: '400px'
    });
  }

  otvoriZaboravljenuSifruDialog() {
    const dialogRef = this.dialog.open(ZaboravljenaSifraModalComponent, {
      width: '400px'
    });
  }
}
