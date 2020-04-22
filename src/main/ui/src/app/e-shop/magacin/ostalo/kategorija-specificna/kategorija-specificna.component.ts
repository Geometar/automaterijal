import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Roba, RobaPage } from 'src/app/e-shop/model/dto';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { RobaService } from 'src/app/e-shop/service/roba.service';
import { VrstaRobe } from 'src/app/e-shop/model/roba.enum';
import { Filter } from 'src/app/e-shop/model/filter';
import { LoginService } from 'src/app/e-shop/service/login.service';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-kategorija-specificna',
  templateUrl: './kategorija-specificna.component.html',
  styleUrls: ['./kategorija-specificna.component.scss']
})
export class KategorijaSpecificnaComponent implements OnInit {

  public roba: Roba[];
  public vrstaRobe = VrstaRobe.OSTALO;

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

  constructor(
    private route: ActivatedRoute,
    private dataService: DataService,
    private robaServis: RobaService,
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit() {
    this.pronandjiRobu();
  }

  pronandjiRobu() {
    this.route.params.subscribe((params: Params) => {
      this.route.queryParams.subscribe(queryParams => {
        this.dataSource = null;
        this.ucitavanje = true;
        this.pronadjenaRoba = true;
        this.pageIndex = queryParams['strana'];
        this.rowsPerPage = queryParams['brojKolona'];
        this.filter.proizvodjacId = queryParams['proizvodjac'];
        this.filter.naStanju = queryParams['naStanju'];
        this.searchValue = queryParams['pretraga'];
        this.robaServis.pronadjiPoKategoriji(
          this.sort, this.rowsPerPage, this.pageIndex, this.searchValue, this.filter.naStanju, this.filter.proizvodjacId, params.id
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

      });
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
    this.route.params.subscribe((params: Params) => {
      const parameterObject = {};
      if (this.pageIndex) {
        parameterObject['strana'] = this.pageIndex;
      }
      if (this.rowsPerPage) {
        parameterObject['brojKolona'] = this.rowsPerPage;
      }
      if (this.filter.proizvodjac) {
        parameterObject['proizvodjac'] = this.filter.proizvodjacId;
      }
      if (this.filter.naStanju) {
        parameterObject['naStanju'] = this.filter.naStanju;
      }
      if (this.searchValue) {
        parameterObject['pretraga'] = this.searchValue;
      }
      const idUrl = params.id.toLowerCase();
      this.router.navigate(['/ostalo', idUrl], { queryParams: parameterObject });
    });
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

  idiNazad() {
    this.router.navigate(['/ostalo']);
  }
}
