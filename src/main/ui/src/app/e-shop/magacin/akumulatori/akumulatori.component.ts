import { Component, OnInit } from '@angular/core';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Roba, RobaPage } from '../../model/dto';
import { RobaService } from '../../service/roba.service';
import { DataService } from '../../service/data/data.service';
import { VrstaRobe } from '../../model/roba.enum';
import { Filter } from '../../model/filter';
import { LoginService } from '../../service/login.service';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-akumulatori',
  templateUrl: './akumulatori.component.html',
  styleUrls: ['./akumulatori.component.css']
})
export class AkumulatoriComponent implements OnInit {

  public roba: Roba[];
  public vrstaRobe = VrstaRobe.AKUMULATORI;

  // Paging and Sorting elements
  public rowsPerPage = 10;
  public pageIndex = 0;
  public sort = null;
  public tableLength;

  public filter: Filter = new Filter();
  public otvoriFilter = false;

  private searchValue = '';
  public ucitavanje = false;
  
  public pronadjenaRoba = true;
  public dataSource: any;

  private alive = true;

  constructor(
    private robaService: RobaService,
    private dataService: DataService,
    private loginService: LoginService) { }

  ngOnInit() {
    this.pronandjiSveAkumulatore();
  }

  pronandjiSveAkumulatore() {
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiAkumulatore(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
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

  pronadjiAkumulatorePoPretrazi(searchValue) {
    this.ucitavanje = true;
    this.dataSource = null;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiAkumulatore(
      this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId
      )
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
    this.pronadjiAkumulatorePoPretrazi(searchValue);
  }

  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.pronadjiAkumulatorePoPretrazi(this.searchValue);
  }

  toogleFilterDiv(otvoriFilter: boolean) {
    this.otvoriFilter = otvoriFilter;
  }

  filtriraj(filter: Filter) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.filter = filter;

    this.pronadjiAkumulatorePoPretrazi(this.searchValue);
  }
}
