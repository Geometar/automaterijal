import { Component, OnInit, OnDestroy } from '@angular/core';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Roba, RobaPage, Magacin } from 'src/app/e-shop/model/dto';
import { RobaService } from 'src/app/e-shop/service/roba.service';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { VrstaRobe } from 'src/app/e-shop/model/roba.enum';
import { Filter } from 'src/app/e-shop/model/filter';
import { LoginService } from 'src/app/e-shop/service/login.service';
import { HttpResponse } from '@angular/common/http';
@Component({
  selector: 'app-kociona',
  templateUrl: './kociona.component.html',
  styleUrls: ['./kociona.component.css']
})
export class KocionaComponent implements OnInit, OnDestroy {

  public roba: Roba[];
  public vrstaRobe = VrstaRobe.ULJA;

  // Paging and Sorting elements
  public rowsPerPage = 10;
  public pageIndex = 0;
  public sort = null;
  public tableLength;

  public filter: Filter = new Filter();
  public filterGrupe = [];
  public proizvodjaci = [];

  public searchValue = '';
  public pocetnoPretrazivanje: boolean;

  public ucitavanje = false;
  public pronadjenaRoba = true;
  public otvoriFilter = false;
  public dataSource: any;

  private alive = true;

  public vrstaUlja = 'kociona';

  constructor(
    private robaService: RobaService,
    private dataService: DataService,
    private loginService: LoginService) { }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
    this.pronandjiSvaKocionaUlja();
  }

  pronandjiSvaKocionaUlja() {
    this.pocetnoPretrazivanje = false;
    this.dataSource = null;
    this.ucitavanje = true;
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
        (response: HttpResponse<Magacin>) => {
          this.loginService.obavesiPartneraAkoJeSesijaIstekla(response.headers.get('AuthenticatedUser'));
          const body = response.body;
          this.filterGrupe = body.podgrupe;
          this.proizvodjaci = body.proizvodjaci;
          this.pronadjenaRoba = true;
          this.roba = body.robaDto.content;
          this.roba = this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
          this.dataSource = this.roba;
          this.rowsPerPage = body.robaDto.size;
          this.pageIndex = body.robaDto.number;
          this.tableLength = body.robaDto.totalElements;
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
    this.pronandjiSvaKocionaUlja();
  }

  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.pronandjiSvaKocionaUlja();
  }

  toogleFilterDiv(otvoriFilter: boolean) {
    this.otvoriFilter = otvoriFilter;
  }

  filtriraj(filter: Filter) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.filter = filter;
    this.pronandjiSvaKocionaUlja();
  }

  ngOnDestroy() {
    this.alive = false;
  }
}
