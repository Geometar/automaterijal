import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable, throwError } from 'rxjs';
import { map, timeoutWith, catchError } from 'rxjs/operators';
import { Proizvodjac } from '../model/proizvodjac';
import { AppUtilsService } from '../utils/app-utils.service';

const DOMAIN_URL = 'http://localhost:8080/api';
const ROBA_URL = '/proizvodjaci';
const FILTERI_URL = '/filteri';
const AKUMULATORI_URL = '/akumulatori';
const ULJA_URL = '/ulja';
const MOTORNA_UTL = '/motorna';

const TIMEOUT = 15000;
const TIMEOUT_ERROR = 'Timeout error!';

@Injectable({
  providedIn: 'root'
})
export class ProizvodjacService {

  constructor(private http: Http, private utils: AppUtilsService) { }

  public pronadjiSveProizvodjace(): Observable<Proizvodjac[]> {
    const fullUrl = DOMAIN_URL + ROBA_URL;

    return this.http
        .get(fullUrl)
        .pipe(
          map((response: any) => response.json()),
          timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
          catchError((error: any) => throwError(error))
        );
  }

  public pronadjiSveProizvodjaceFiltera(): Observable<Proizvodjac[]> {
    const fullUrl = DOMAIN_URL + ROBA_URL + FILTERI_URL;

    return this.http
        .get(fullUrl)
        .pipe(
          map((response: any) => response.json()),
          timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
          catchError((error: any) => throwError(error))
        );
  }

  public pronadjiSveProizvodjaceAkumulatora(): Observable<Proizvodjac[]> {
    const fullUrl = DOMAIN_URL + ROBA_URL + AKUMULATORI_URL;

    return this.http
        .get(fullUrl)
        .pipe(
          map((response: any) => response.json()),
          timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
          catchError((error: any) => throwError(error))
        );
  }

  public pronadjiSveProizvodjaceUljaPoVrsti(vrstaUlja): Observable<Proizvodjac[]> {
    const fullUrl = DOMAIN_URL + ROBA_URL + ULJA_URL + this.utils.vratiPutDoResursaZaUlje(vrstaUlja);

    return this.http
        .get(fullUrl)
        .pipe(
          map((response: any) => response.json()),
          timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
          catchError((error: any) => throwError(error))
        );
  }
}
