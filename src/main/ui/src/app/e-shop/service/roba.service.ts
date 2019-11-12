import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { timeoutWith, catchError } from 'rxjs/operators';
import { Sort } from '@angular/material';
import { AppUtilsService } from '../utils/app-utils.service';
import { environment } from 'src/environments/environment';
import { Roba, RobaPage } from '../model/dto';

const DOMAIN_URL = environment.baseUrl + '/api';
const ROBA_URL = '/roba';
const FILTERI_URL = '/filteri';
const AKUMULATORI_URL = '/akumulatori';
const ULJA_URL = '/ulja';
const OSTALE_KATEGORIJE_URL = '/kategorije';

const TIMEOUT = 35000;
const TIMEOUT_ERROR = 'Timeout error!';

@Injectable({
  providedIn: 'root'
})
export class RobaService {


  constructor(private http: HttpClient, private utils: AppUtilsService) { }

  public pronadjiSvuRobu(sort: Sort, pageSize, page, searchValue, naStanju, proizvodjacId): Observable<HttpResponse<Object>> {
    const parameterObject = {};
    parameterObject['pageSize'] = pageSize;
    parameterObject['page'] = page;
    if (sort) {
      parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
      parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
    }
    parameterObject['searchTerm'] = searchValue;
    parameterObject['proizvodjac'] = proizvodjacId;
    parameterObject['naStanju'] = naStanju;
    const parametersString = this.utils.vratiKveriParametre(parameterObject);
    const fullUrl = DOMAIN_URL + ROBA_URL + parametersString;

    return this.http
      .get(fullUrl, {observe: 'response'})
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error))
      );
  }

  public pronadjiFiltere(sort: Sort, pageSize, page, searchValue, naStanju, proizvodjacId): Observable<HttpResponse<Object>> {
    const parameterObject = {};
    parameterObject['pageSize'] = pageSize;
    parameterObject['page'] = page;
    if (sort) {
      parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
      parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
    }
    parameterObject['searchTerm'] = searchValue;
    parameterObject['proizvodjac'] = proizvodjacId;
    parameterObject['naStanju'] = naStanju;
    const parametersString = this.utils.vratiKveriParametre(parameterObject);
    const fullUrl = DOMAIN_URL + ROBA_URL + FILTERI_URL + parametersString;
    return this.http
      .get(fullUrl, {observe: 'response'})
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error))
      );
  }

  public pronadjiAkumulatore(sort: Sort, pageSize, page, searchValue, naStanju, proizvodjacId): Observable<HttpResponse<Object>> {
    const parameterObject = {};
    parameterObject['pageSize'] = pageSize;
    parameterObject['page'] = page;
    if (sort) {
      parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
      parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
    }
    parameterObject['searchTerm'] = searchValue;
    parameterObject['proizvodjac'] = proizvodjacId;
    parameterObject['naStanju'] = naStanju;
    const parametersString = this.utils.vratiKveriParametre(parameterObject);
    const fullUrl = DOMAIN_URL + ROBA_URL + AKUMULATORI_URL + parametersString;
    return this.http
      .get(fullUrl, {observe: 'response'})
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error))
      );
  }

  public pronadjiUlje(sort: Sort, pageSize, page, searchValue, naStanju, proizvodjacId, vrstaUlja): Observable<HttpResponse<Object>> {
    const parameterObject = {};
    parameterObject['pageSize'] = pageSize;
    parameterObject['page'] = page;
    if (sort) {
      parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
      parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
    }
    parameterObject['searchTerm'] = searchValue;
    parameterObject['proizvodjac'] = proizvodjacId;
    parameterObject['naStanju'] = naStanju;
    const parametersString = this.utils.vratiKveriParametre(parameterObject);
    const fullUrl = DOMAIN_URL + ROBA_URL + ULJA_URL + this.utils.vratiPutDoResursaZaUlje(vrstaUlja) + parametersString;
    return this.http
      .get(fullUrl, {observe: 'response'})
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error))
      );
  }

  public pronadjiPoKategoriji(
    sort: Sort, pageSize, page, searchValue, naStanju, proizvodjacId, kategorija: string
    ): Observable<HttpResponse<Object>> {
    const parameterObject = {};
    parameterObject['pageSize'] = pageSize;
    parameterObject['page'] = page;
    if (sort) {
      parameterObject['sortBy'] = sort.active.toLocaleUpperCase();
      parameterObject['sortDirection'] = sort.direction.toLocaleUpperCase();
    }
    parameterObject['searchTerm'] = searchValue;
    parameterObject['proizvodjac'] = proizvodjacId;
    parameterObject['naStanju'] = naStanju;
    const parametersString = this.utils.vratiKveriParametre(parameterObject);
    const fullUrl = DOMAIN_URL + OSTALE_KATEGORIJE_URL + '/' + kategorija.toUpperCase() + parametersString;
    return this.http
      .get(fullUrl, {observe: 'response'})
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error))
      );
  }

  public ostaleKategorije(): Observable<any> {
    const fullUrl = DOMAIN_URL + OSTALE_KATEGORIJE_URL;
    return this.http
      .get(fullUrl)
      .pipe(
        timeoutWith(TIMEOUT, throwError(TIMEOUT_ERROR)),
        catchError((error: any) => throwError(error))
      );
  }
}
