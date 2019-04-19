import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Sort } from '@angular/material';
import { Roba, Partner } from 'src/app/e-shop/model/dto';
import { Korpa } from 'src/app/e-shop/model/porudzbenica';
import { LoginService } from 'src/app/e-shop/service/login.service';
import { AppUtilsService } from 'src/app/e-shop/utils/app-utils.service';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { RobaService } from 'src/app/e-shop/service/roba.service';
import { VrstaRobe } from 'src/app/e-shop/model/roba.enum';
import { Filter } from 'src/app/e-shop/model/filter';
import { NotifikacijaService } from 'src/app/shared/service/notifikacija.service';
import { MatSnackBarKlase } from 'src/app/shared/model/konstante';

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
  public lastSearchValue = '';
  public pocetnoPretrazivanje: boolean;

  public ucitavanje = false;
  public pronadjenaRoba = true;

  public otvoriFilter = false;

  // Tabela
  private columnDefinitions = [
    { def: 'katbr', ifNotAuth: true },
    { def: 'katbrpro', ifNotAuth: true },
    { def: 'proizvodjac', ifNotAuth: true },
    { def: 'naziv', ifNotAuth: true },
    { def: 'cena', ifNotAuth: true },
    { def: 'stanje', ifNotAuth: true },
    { def: 'kolicina', ifNotAuth: false },
    { def: 'korpa', ifNotAuth: false },
    { def: 'u-korpi', ifNotAuth: false },
  ];
  public dataSource: any;

  private alive = true;
  private korpa: Korpa;
  public partner: Partner;
  constructor(
    private route: ActivatedRoute,
    private loginServis: LoginService,
    private utilsService: AppUtilsService,
    private dataService: DataService,
    private robaServis: RobaService,
    private notifikacijaServis: NotifikacijaService,
    private router: Router
  ) { }

  getDisplayedColumns(): string[] {
    const isPartner = this.partner.ppid != null;
    const dataColumns = this.columnDefinitions
      .filter(cd => isPartner || cd.ifNotAuth)
      .map(cd => cd.def);
    return dataColumns;
  }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
    this.dataService.trenutnaKorpa.subscribe(korpa => this.korpa = korpa);
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.pronandjiRobu();
  }

  pronandjiRobu() {
    this.route.params.subscribe((params: Params) => {
      this.robaServis.pronadjiPoKategoriji(this.sort, this.rowsPerPage, this.pageIndex, null, null, null, params.id)
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
            this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
            this.dataSource = this.roba;
            this.rowsPerPage = res.size;
            this.pageIndex = res.number;
            this.tableLength = res.totalElements;
          },
          error => {
            this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
          });
    });
  }

  pronaciPoTrazenojReci(searchValue) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.pronadjiSvuRobuPoPretrazi(searchValue);
  }

  pronadjiSvuRobuPoPretrazi(searchValue) {
    this.pocetnoPretrazivanje = false;
    this.lastSearchValue = searchValue;
    this.dataSource = null;
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.route.params.subscribe((params: Params) => {
      this.robaServis.pronadjiPoKategoriji(
        this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId, params.id)
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
            this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
            this.dataSource = this.roba;
            this.rowsPerPage = res.size;
            this.pageIndex = res.number;
            this.tableLength = res.totalElements;
          },
          error => {
            this.roba = null;
            console.log('Podnaci robu izbacilo je gresko');
          });
    });
  }
  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.pronadjiSvuRobuPoPretrazi(this.searchValue);
  }

  sortData(sort: Sort) {
    this.sort = sort;
    let searchTerm;
    if (this.lastSearchValue) {
      searchTerm = this.lastSearchValue;
    } else if (this.searchValue) {
      searchTerm = this.searchValue;
    } else {
      searchTerm = null;
    }
    this.pronadjiSvuRobuPoPretrazi(this.searchValue);
  }

  toogleFilterDiv() {
    this.otvoriFilter = !this.otvoriFilter;
  }

  filtriraj(filter: Filter) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.filter = filter;
    this.pronadjiSvuRobuPoPretrazi(this.searchValue);
  }

  dodajUKorpu(roba: Roba) {
    const snackBarPoruka = this.utilsService.dodajUKorpu(roba);
    this.notifikacijaServis.notify(snackBarPoruka, MatSnackBarKlase.Zelena);
    this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
  }

  uKorpi(katBr: string) {
    return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
  }

  idiNazad() {
    this.router.navigate(['/ostalo']);
  }
}
