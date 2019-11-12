import { Component, OnInit } from '@angular/core';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Roba, Partner, RobaPage } from 'src/app/e-shop/model/dto';
import { RobaService } from 'src/app/e-shop/service/roba.service';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { VrstaRobe } from 'src/app/e-shop/model/roba.enum';
import { Filter } from 'src/app/e-shop/model/filter';
import { LoginService } from 'src/app/e-shop/service/login.service';
import { HttpResponse } from '@angular/common/http';
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
    this.pronandjiSavAntifriz();
  }

  pronandjiSavAntifriz() {
    this.ucitavanje = true;
    this.dataSource = null;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiUlje(
      this.sort, this.rowsPerPage, this.pageIndex, this.searchValue, this.filter.naStanju, this.filter.proizvodjacId, this.vrstaUlja
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

  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.pronandjiSavAntifriz();
  }

  pronaciPoTrazenojReci(searchValue) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.searchValue = searchValue;
    this.pronandjiSavAntifriz();
  }

  toogleFilterDiv(otvoriFilter: boolean) {
    this.otvoriFilter = otvoriFilter;
  }

  filtriraj(filter: Filter) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.filter = filter;
    this.pronandjiSavAntifriz();
  }
}
