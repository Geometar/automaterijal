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
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-filteri',
  templateUrl: './filteri.component.html',
  styleUrls: ['./filteri.component.css']
})
export class FilteriComponent implements OnInit {

  public roba: Roba[];
  public vrstaRobe = VrstaRobe.FILTERI;

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

  private treutniParametri = {};

  private alive = true;

  constructor(
    private robaService: RobaService,
    private dataService: DataService,
    private loginService: LoginService,
    private aktivnaRuta: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.uzmiParametreIzUrla();
  }

  uzmiParametreIzUrla() {
    this.aktivnaRuta.queryParams.subscribe(params => {
      this.treutniParametri = params;
      this.pageIndex = params['strana'];
      this.rowsPerPage = params['brojKolona'];
      this.filter.proizvodjacId = params['proizvodjac'];
      this.filter.naStanju = params['naStanju'];
      this.searchValue = params['pretraga'];
      this.pronandjiSveFiltere();
    });
  }

  pronandjiSveFiltere() {
    this.dataSource = null;
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiFiltere(
      this.sort, this.rowsPerPage, this.pageIndex, this.searchValue, this.filter.naStanju, this.filter.proizvodjacId
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
    this.dodajParametreUURL();

  }

  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.dodajParametreUURL();
  }

  dodajParametreUURL() {
    const parameterObject = {};
    if (this.pageIndex) {
      parameterObject['strana'] = this.pageIndex;
    }
    if (this.rowsPerPage) {
      parameterObject['brojKolona'] = this.rowsPerPage;
    }
    if (this.filter.proizvodjacId) {
      parameterObject['proizvodjac'] = this.filter.proizvodjacId;
    }
    if (this.filter.naStanju) {
      parameterObject['naStanju'] = this.filter.naStanju;
    }
    if (this.searchValue) {
      parameterObject['pretraga'] = this.searchValue;
    }
    if (
      parameterObject['pretraga'] &&
      this.treutniParametri['pretraga'] &&
      parameterObject['pretraga'] === this.treutniParametri['pretraga']
    ) {
      this.pronandjiSveFiltere();
    } else {
      this.router.navigate(['/filteri'], { queryParams: parameterObject });
    }

  }
  toogleFilterDiv(otvoriFilter: boolean) {
    this.otvoriFilter = otvoriFilter;
  }

  filtriraj(filter: Filter) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.filter = filter;
    this.dodajParametreUURL();
  }
}
