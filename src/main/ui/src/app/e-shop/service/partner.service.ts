import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { timeoutWith, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Partner, ResetSifre, PromenaSifre } from '../model/dto';

const PARTNER_URL = '/api/partner';
const RESETOVANJE_SIFRE_URL = '/promena-sifre';

const TIMEOUT = 15000;
const TIMEOUT_ERROR = 'Timeout error!';

@Injectable({
  providedIn: 'root'
})
export class PartnerService {

  constructor(private http: HttpClient) { }

  public updejtujPartnera(partner: Partner): Observable<Partner> {
    const fullUrl = PARTNER_URL;

    return this.http
        .put(fullUrl, partner)
        .pipe(
          timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
          catchError((error: any) => throwError(error))
        );
  }

  public promeniSifru(reset: PromenaSifre): Observable<any> {
    const fullUrl = PARTNER_URL + RESETOVANJE_SIFRE_URL;

    return this.http
        .put(fullUrl, reset)
        .pipe(
          timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
          catchError((error: any) => throwError(error))
        );
  }
}
