import { Injectable } from '@angular/core';
import { throwError, BehaviorSubject, EMPTY, Observable } from 'rxjs';
import { Credentials, Partner } from '../model/dto';
import { timeoutWith, catchError, finalize } from 'rxjs/operators';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { AppUtilsService } from '../utils/app-utils.service';
import { Router } from '@angular/router';
import { LocalStorageService } from './data/local-storage.service';
import { DataService } from './data/data.service';
import { MatDialog } from '@angular/material';
import { SesijaIsteklaModalComponent } from 'src/app/shared/modal/sesija-istekla-modal/sesija-istekla-modal.component';

const TIMEOUT = 15000;
const TIMEOUT_ERROR = 'Timeout error!';

const LOGIN_URL = '/login';
const LOGOUT_URL = '/logout';
const PARTNER_URL = '/api/partner';
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
    const sesijaDialog = this.dialog.open(SesijaIsteklaModalComponent, {
      width: '400px'
    });

    sesijaDialog.afterClosed().subscribe(() => {
      this.logovanjeSubjekat.next(false);
      this.partnerSubjekat.next(null);
      this.storageServis.logout();
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
