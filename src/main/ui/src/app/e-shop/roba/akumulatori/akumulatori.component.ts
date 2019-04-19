import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Roba, Partner } from '../../model/dto';
import { Korpa } from '../../model/porudzbenica';
import { RobaService } from '../../service/roba.service';
import { AppUtilsService } from '../../utils/app-utils.service';
import { LoginService } from '../../service/login.service';
import { DataService } from '../../service/data/data.service';
import { VrstaRobe } from '../../model/roba.enum';
import { Filter } from '../../model/filter';
import { NotifikacijaService } from 'src/app/shared/service/notifikacija.service';
import { MatSnackBarKlase } from 'src/app/shared/model/konstante';
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
    { def: 'rabat', ifNotAuth: false },
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
    private robaService: RobaService,
    private utilsService: AppUtilsService,
    private loginServis: LoginService,
    private dataService: DataService,
    private notifikacijaServis: NotifikacijaService) { }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
    this.dataService.trenutnaKorpa.subscribe(korpa => this.korpa = korpa);
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.pronandjiSveAkumulatore();
  }

  getDisplayedColumns(): string[] {
    const isPartner = this.partner.ppid != null;
    const dataColumns = this.columnDefinitions
      .filter(cd => isPartner || cd.ifNotAuth)
      .map(cd => cd.def);
    return dataColumns;
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
          this.dataSource = this.roba;
          this.rowsPerPage = res.size;
          this.pageIndex = res.number;
          this.tableLength = res.totalElements;
        },
        error => {
          this.roba = null;
          console.log('Podnaci robu izbacilo je gresko');
        });
  }

  pronadjiAkumulatorePoPretrazi(searchValue) {
    this.pocetnoPretrazivanje = false;
    this.lastSearchValue = searchValue;
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
          this.dataSource = this.roba;
          this.rowsPerPage = res.size;
          this.pageIndex = res.number;
          this.tableLength = res.totalElements;
        },
        error => {
          this.roba = null;
          console.log('Podnaci robu izbacilo je gresko');
        });
  }

  pronaciPoTrazenojReci(searchValue) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.pronadjiAkumulatorePoPretrazi(searchValue);
  }

  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
    this.pronadjiAkumulatorePoPretrazi(this.searchValue);
  }

  sortData(sort: Sort) {
    this.sort = sort;
    this.pronadjiAkumulatorePoPretrazi(this.searchValue);
  }

  toogleFilterDiv() {
    this.otvoriFilter = !this.otvoriFilter;
  }

  filtriraj(filter: Filter) {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.filter = filter;

    this.pronadjiAkumulatorePoPretrazi(this.searchValue);
  }

  dodajUKorpu(roba: Roba) {
    const snackBarPoruka = this.utilsService.dodajUKorpu(roba);
    this.notifikacijaServis.notify(snackBarPoruka, MatSnackBarKlase.Zelena);
    this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
  }

  uKorpi(katBr: string) {
    return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
  }
}
