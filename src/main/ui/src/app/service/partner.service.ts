import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { timeoutWith, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Partner } from '../model/dto';

const DOMAIN_URL = 'http://localhost:8080/api';
const PARTNER_URL = '/partner';

const TIMEOUT = 15000;
const TIMEOUT_ERROR = 'Timeout error!';

@Injectable({
  providedIn: 'root'
})
export class PartnerService {

  constructor(private http: HttpClient) { }

  public updejtujPartnera(partner: Partner): Observable<Partner> {
    const fullUrl = DOMAIN_URL + PARTNER_URL;

    return this.http
        .put(fullUrl, partner)
        .pipe(
          timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
          catchError((error: any) => throwError(error))
        );
  }
}
