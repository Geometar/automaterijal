import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Registracija, ResetSifre } from '../model/dto';
import { timeoutWith, catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material';

const DOMAIN_URL = 'http://localhost:8080/api/email';
const REGISTRACIJA_URL = '/registracija';
const RESETOVANJE_SIFRE_URL = '/zaboravljena-sifra';

const TIMEOUT = 15000;
const TIMEOUT_ERROR = 'Timeout error!';
@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor(
    private http: HttpClient) { }

  public posaljiMailZaRegistraciju(registracija: Registracija): Observable<any> {
    const fullUrl = DOMAIN_URL + REGISTRACIJA_URL;
   return this.http.post(fullUrl, registracija)
    .pipe(
      timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
      catchError((error: any) => throwError(error))
    );
  }

  public posaljiMailZaResetovanjeSifre(email: ResetSifre): Observable<any> {
    const fullUrl = DOMAIN_URL + RESETOVANJE_SIFRE_URL;
   return this.http.post(fullUrl, email)
    .pipe(
      timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
      catchError((error: any) => throwError(error))
    );
  }
}
