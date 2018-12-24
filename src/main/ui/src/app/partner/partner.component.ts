import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Partner } from '../model/dto';
import { PartnerService } from '../service/partner.service';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TouchSequence } from 'selenium-webdriver';
import { MatSnackBar } from '@angular/material';

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
  private alive = true;

  // sve forme
  public adresaForm: FormGroup;
  public adresaSubmited = false;
  public emailForm: FormGroup;
  public emailSubmited = false;
  public usernameForm: FormGroup;
  public usernameSubmited = false;
  public passwordForm: FormGroup;
  public passwordSubmited = false;

  constructor(
    private loginServis: LoginService,
    private partnerServis: PartnerService,
    private formBuilder: FormBuilder,
    public snackBar: MatSnackBar) { }

  ngOnInit() {
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    if (this.partner) {
      this.daLiDuguje = this.partner.stanje < 0;
    }
    this.inicijalizujSveRegistracioneForme();
  }

  inicijalizujSveRegistracioneForme() {
    this.adresaForm = this.formBuilder.group({
      ulica: ['', [Validators.required, Validators.minLength(3)]],
      grad: ['', [Validators.required, Validators.minLength(2)]]
    });
    this.emailForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
    });
    this.usernameForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
    });
    this.passwordForm = this.formBuilder.group({
      staraSifra: ['', [Validators.required, Validators.minLength(3)]],
      novaSifra: ['', [Validators.required, Validators.minLength(3)]],
      novaSifra2: ['', [Validators.required, Validators.minLength(3)]],
    });
  }

  public daLiKorisnickoImeTrebaDaBudeEmail() {
    return this.korisnickoImeMetod === 'email';
  }

  promeniAdresu(ulica: string, grad: string) {
    const poruka = 'Adresa uspesno promenjena.';
    this.adresaSubmited = true;
    if (this.adresaForm.invalid) {
      const a = this.a.grad.errors;
      return;
    }
    this.partner.adresa = ulica + ', ' + grad;
    this.updejtPartnera(this.partner, poruka);
  }

  promeniLEmail(email: string) {
    const poruka = 'Email je uspesno promenjen.';
    this.emailSubmited = true;
    if (this.emailForm.invalid) {
      return;
    }
    this.partner.email = email;
    this.updejtPartnera(this.partner, poruka);
  }

  promeniUsername(username: string) {
    this.usernameSubmited = true;
    if (this.korisnickoImeMetod === 'email') {
      username = this.partner.email;
    } else if (this.usernameForm.invalid) {
      return;
    }
    const poruka = 'Vaše novo korisničko ime je: ' + username;
    this.partner.webKorisnik = username;
    this.partnerServis.updejtujPartnera(this.partner)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 400) {
            this.korisnickoImeJeZauzeto = true;
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false)
      )
      .subscribe(
        res => {
          this.korisnickoImeJeZauzeto = false;
          this.partner = res;
          this.otvoriSnackBar(poruka);
        },
        error => {
          console.log('Updejtovanje partnera nije uspelo');
        });
  }

  promeniSifru(staraSifra: string, novaSifra: string, novaSifra2: string) {
    this.passwordSubmited = true;
    if (this.passwordForm.invalid ||
      novaSifra === staraSifra) {
      const a = this.s.staraSifra.errors.minLength;
      return;
    }
    this.partner.noviPassword = novaSifra;
    this.partner.stariPassword = staraSifra;
    const poruka = 'Vaša šifra je uspeno promenjena';
    this.partnerServis.updejtujPartnera(this.partner)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 400) {
            this.losaSifra = true;
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false)
      )
      .subscribe(
        res => {
          this.partner = res;
          this.losaSifra = false;
          this.otvoriSnackBar(poruka);
        },
        error => {
          console.log('Updejtovanje partnera nije uspelo');
        });
  }

  updejtPartnera(partner: Partner, poruka: string) {
    this.partnerServis.updejtujPartnera(this.partner)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => throwError(error)),
        finalize(() => this.ucitavanje = false)
      )
      .subscribe(
        res => {
          this.partner = res;
          this.otvoriSnackBar(poruka);
        },
        error => {
          console.log('Updejtovanje partnera nije uspelo');
        });
  }

  otvoriSnackBar(poruka: string) {
    this.snackBar.open(poruka, '', {
      duration: 2000,
    });
  }

  // convenience getter for easy access to form fields
  get a() { return this.adresaForm.controls; }
  get e() { return this.emailForm.controls; }
  get u() { return this.usernameForm.controls; }
  get s() { return this.passwordForm.controls; }
}
