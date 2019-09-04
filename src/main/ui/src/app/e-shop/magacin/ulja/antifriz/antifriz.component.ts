import { Component, OnInit } from '@angular/core';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Roba, Partner } from 'src/app/e-shop/model/dto';
import { RobaService } from 'src/app/e-shop/service/roba.service';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { VrstaRobe } from 'src/app/e-shop/model/roba.enum';
import { Filter } from 'src/app/e-shop/model/filter';
import { LoginService } from 'src/app/e-shop/service/login.service';
@Component({
  selector: 'app-antifriz',
  templateUrl: './antifriz.component.html',
  styleUrls: ['./antifriz.component.css']
})
export class AntifrizComponent implements OnInit {

  public roba: Roba[];
  public vrstaRobe = VrstaRobe.ULJA;

  // Paging and Sorting elements
  public rowsPerPage = 10;
  public pageIndex = 0;
  public sort = null;
  public tableLength;

  public filter: Filter = new Filter();

  public searchValue = '';
  public lastSearchValue = '';
  public pocetnoPretrazivanje: boolean;

  public ucitavanje = false;
  public pronadjenaRoba = true;
  public otvoriFilter = false;
  public dataSource: any;

  private alive = true;

  public vrstaUlja = 'antifriz';

  constructor(
    private robaService: RobaService,
    private dataService: DataService,
    private loginService: LoginService) { }

  ngOnInit() {
    this.loginService.izbaciPartneraIzSesiseAkoJeUMemoriji();
    this.pocetnoPretrazivanje = true;
    this.pronandjiSavAntifriz();
  }

  pronandjiSavAntifriz() {
    this.ucitavanje = true;
    this.pronadjenaRoba = true;

    this.robaService.pronadjiUlje(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, this.vrstaUlja)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 404) {
            this.pronadjenaRoba = false;
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false)
      )
      .subscribe(
        res => {
          this.pronadjenaRoba = true;
          this.roba = res.content;
          this.roba = this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
          this.dataSource = this.roba;
          this.rowsPerPage = res.size;
          this.pageIndex = res.number;
          this.tableLength = res.totalElements;
        },
        error => {
          this.roba = null;
        });
  }

  pronadjiEntitetePoPretrazi(searchValue) {
    this.pocetnoPretrazivanje = false;
    this.lastSearchValue = searchValue;
    this.ucitavanje = true;
    this.dataSource = null;
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiUlje(
      this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId, this.vrstaUlja
    )
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 404) {
            this.pronadjenaRoba = false;
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false)
      )
      .subscribe(
        res => {
          this.pronadjenaRoba = true;
          this.roba = res.content;
          this.roba = this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
          this.dataSource = this.roba;
          this.rowsPerPage = res.size;
          this.pageIndex = res.number;
          this.tableLength = res.totalElements;
        },
        error => {
          this.roba = null;
        });
  }

  pronaciPoTrazenojReci(searchValue) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.pronadjiEntitetePoPretrazi(searchValue);
  }

  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.pronadjiEntitetePoPretrazi(this.searchValue);
  }

  toogleFilterDiv() {
    this.otvoriFilter = !this.otvoriFilter;
  }

  filtriraj(filter: Filter) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.filter = filter;
    this.pronadjiEntitetePoPretrazi(this.searchValue);
  }
}
