import { Injectable } from '@angular/core';
import { throwError, BehaviorSubject, Observable } from 'rxjs';
import { Credentials, Partner } from '../model/dto';
import { timeoutWith, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { AppUtilsService } from '../utils/app-utils.service';
import { Router } from '@angular/router';
import { LocalStorageService } from './data/local-storage.service';
import { DataService } from './data/data.service';
import { MatDialog } from '@angular/material';
import { SesijaIsteklaModalComponent } from 'src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component';
import { environment } from 'src/environments/environment';

const TIMEOUT = 15000;
const TIMEOUT_ERROR = 'Timeout error!';

const LOGIN_URL = environment.baseUrl + '/login';
const LOGOUT_URL = environment.baseUrl +  '/logout';
const PARTNER_URL = environment.baseUrl +  '/api/partner';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private partner: Partner = this.storageServis.procitajPartneraIzMemorije() || null;
  private partnerSubjekat = new BehaviorSubject(this.partner);
  public ulogovaniPartner = this.partnerSubjekat.asObservable();

  private logovanjeSubjekat = new BehaviorSubject(this.partner !== null);
  public daLiJePartnerUlogovan = this.logovanjeSubjekat.asObservable();

  constructor(
    private http: HttpClient,
    private router: Router,
    private utils: AppUtilsService,
    private korpaServis: DataService,
    private storageServis: LocalStorageService,
    public dialog: MatDialog) { }

  public ulogujSe(credentials: Credentials): Observable<any> {
    const parameterObject = {};
    parameterObject['username'] = credentials.username;
    parameterObject['password'] = credentials.password;
    parameterObject['submit'] = 'Login';
    const parametersString = this.utils.vratiKveriParametre(parameterObject);

    const fullUrl = LOGIN_URL + parametersString;

    return this.http.post(fullUrl, {}, { responseType: 'text' })
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error))
      );
  }

  public vratiUlogovanogKorisnika(daLiJePrviRequest: boolean): Observable<any> {
    const parameterObject = {};
    parameterObject['prviRequest'] = daLiJePrviRequest;
    const parametersString = this.utils.vratiKveriParametre(parameterObject);

    const fullUrl = PARTNER_URL + parametersString;

    return this.http.get(fullUrl)
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error)));
  }

  public setDaLiJeUserLogovan(bool: boolean) {
    this.logovanjeSubjekat.next(bool);
  }

  public setUlogovanogPartner(partner: Partner) {
    this.partnerSubjekat.next(partner);
    this.storageServis.sacuvajPartneraUMemoriju(partner);
  }

  public izbaciPartnerIzSesije() {
    this.storageServis.logout();
    this.logovanjeSubjekat.next(false);
    this.partnerSubjekat.next(null);
    const sesijaDialog = this.dialog.open(SesijaIsteklaModalComponent, {
      width: '400px'
    });

    sesijaDialog.afterClosed().subscribe(() => {
      this.logovanjeSubjekat.next(false);
      this.partnerSubjekat.next(null);
    });
  }

  public logout() {
    const fullUrl = LOGOUT_URL;
    this.http.post(fullUrl, {}, { responseType: 'text' })
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error))
      )
      .subscribe(() => {
        this.korpaServis.ocistiKorpu();
        this.logovanjeSubjekat.next(false);
        this.partnerSubjekat.next(null);
        this.storageServis.logout();
        this.router.navigateByUrl('naslovna');
      });
  }
}
