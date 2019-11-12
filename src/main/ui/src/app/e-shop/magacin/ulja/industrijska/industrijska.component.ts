import { Component, OnInit } from '@angular/core';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY, Subject } from 'rxjs';
import { Roba, RobaPage } from 'src/app/e-shop/model/dto';
import { RobaService } from 'src/app/e-shop/service/roba.service';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { VrstaRobe } from 'src/app/e-shop/model/roba.enum';
import { Filter } from 'src/app/e-shop/model/filter';
import { LoginService } from 'src/app/e-shop/service/login.service';
import { HttpResponse } from '@angular/common/http';
@Component({
  selector: 'app-industrijska',
  templateUrl: './industrijska.component.html',
  styleUrls: ['./industrijska.component.css']
})
export class IndustrijskaComponent implements OnInit {

  public roba: Roba[];
  public vrstaRobe = VrstaRobe.ULJA;

  // Paging and Sorting elements
  public rowsPerPage = 10;
  public pageIndex = 0;
  public sort = null;
  public tableLength;

  public filter: Filter = new Filter();
  public vrstaIndustijskihUlja: Subject<string> = new Subject<string>();

  public searchValue = '';
  public lastSearchValue = '';
  public pocetnoPretrazivanje: boolean;

  public ucitavanje = false;
  public pronadjenaRoba = true;
  public otvoriFilter = false;
  public dataSource: any;

  public vrste: string[] = ['Hidraulično ulje', 'Kompresorkso ulje', 'Reduktorsko ulje',
    'Transformatorsko ulje', 'Turbinska ulja', 'Ulja za pneumatske alate', 'Ulja za klizne staze', 'Ulja za prenos toplote'];
  public izabranaVrsta: string = this.vrste[0];

  public vrsteUlja = [
    { 'url': 'hidraulicna', 'naziv': 'Hidraulično ulje' },
    { 'url': 'kompresorska', 'naziv': 'Kompresorkso ulje' },
    { 'url': 'redutktorska', 'naziv': 'Reduktorsko ulje' },
    { 'url': 'transformatorska', 'naziv': 'Transformatorsko ulje' },
    { 'url': 'turbinska', 'naziv': 'Turbinska ulja' },
    { 'url': 'pneumatska', 'naziv': 'Ulja za pneumatske alate' },
    { 'url': 'klizna', 'naziv': 'Ulja za klizne staze' },
    { 'url': 'prenosna', 'naziv': 'Ulja za prenos toplote' },
  ];

  private alive = true;

  public vrstaUlja = 'hidraulicna';

  constructor(
    private robaService: RobaService,
    private dataService: DataService,
    private loginService: LoginService) { }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
    this.pronandjiUlja();
  }

  pronandjiUlja() {
    this.dataSource = null;
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 404) {
            this.pronadjenaRoba = false;
            this.loginService.obavesiPartneraAkoJeSesijaIstekla(error.headers.get('AuthenticatedUser'));
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false)
      )
      .subscribe(
        (response: HttpResponse<RobaPage>) => {
          this.loginService.obavesiPartneraAkoJeSesijaIstekla(response.headers.get('AuthenticatedUser'));
          const body = response.body;
          this.pronadjenaRoba = true;
          this.roba = body.content;
          this.roba = this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
          this.dataSource = this.roba;
          this.rowsPerPage = body.size;
          this.pageIndex = body.number;
          this.tableLength = body.totalElements;
        },
        error => {
          this.roba = null;
        });
  }

  pronadjiEntitetePoPretrazi(searchValue) {
    this.pocetnoPretrazivanje = false;
    this.lastSearchValue = searchValue;
    this.dataSource = null;
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiUlje(
      this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId, this.vrstaUlja)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 404) {
            this.pronadjenaRoba = false;
            this.loginService.obavesiPartneraAkoJeSesijaIstekla(error.headers.get('AuthenticatedUser'));
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false)
      )
      .subscribe(
        (response: HttpResponse<RobaPage>) => {
          this.loginService.obavesiPartneraAkoJeSesijaIstekla(response.headers.get('AuthenticatedUser'));
          const body = response.body;
          this.pronadjenaRoba = true;
          this.roba = body.content;
          this.roba = this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
          this.dataSource = this.roba;
          this.rowsPerPage = body.size;
          this.pageIndex = body.number;
          this.tableLength = body.totalElements;
        },
        error => {
          this.roba = null;
        });
  }

  pronaciPoTrazenojReci(searchValue) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.searchValue = searchValue;
    this.pronadjiEntitetePoPretrazi(searchValue);
  }

  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.pronadjiEntitetePoPretrazi(this.searchValue);
  }

  toogleFilterDiv(otvoriFilter: boolean) {
    this.otvoriFilter = otvoriFilter;
  }

  filtriraj(filter: Filter) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.filter = filter;
    this.pronadjiEntitetePoPretrazi(this.searchValue);
  }

  onChange() {
    this.vrsteUlja.forEach(vrsta => {
      if (vrsta.naziv === this.izabranaVrsta) {
        this.vrstaUlja = vrsta.url;
        this.vrstaIndustijskihUlja.next(this.vrstaUlja);
      }
    });
    this.pronandjiUlja();
  }
}
