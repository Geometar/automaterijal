import { Component, OnInit } from '@angular/core';
import { RobaService } from '../service/roba.service';
import { Roba, Partner } from '../model/dto';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Sort, MatSnackBar } from '@angular/material';
import { DataService } from '../service/data/data.service';
import { Korpa } from '../model/porudzbenica';
import { AppUtilsService } from '../utils/app-utils.service';
import { LoginService } from '../service/login.service';
import { VrstaRobe } from '../model/roba.enum';
import { Filter } from '../model/filter';

@Component({
  selector: 'app-roba',
  templateUrl: './roba.component.html',
  styleUrls: ['./roba.component.css']
})
export class RobaComponent implements OnInit {

  public roba: Roba[];
  public vrstaRobe = VrstaRobe.SVE;

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

  constructor(private robaService: RobaService,
    private loginServis: LoginService,
    private dataService: DataService,
    private utilsService: AppUtilsService,
    public korpaSnackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
    this.dataService.trenutnaKorpa.subscribe(korpa => this.korpa = korpa);
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.pronadjiSvuRobu();
  }

  getDisplayedColumns(): string[] {
    const isPartner = this.partner.ppid != null;
    const dataColumns = this.columnDefinitions
      .filter(cd => isPartner || cd.ifNotAuth)
      .map(cd => cd.def);
    return dataColumns;
  }

  pronadjiSvuRobu() {
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiSvuRobu(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
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
    this.pronadjiSvuRobuPoPretrazi(searchValue);
  }

  pronadjiSvuRobuPoPretrazi(searchValue) {
    this.pocetnoPretrazivanje = false;
    this.lastSearchValue = searchValue;
    this.dataSource = null;
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.robaService.pronadjiSvuRobu(
      this.sort, this.rowsPerPage, this.pageIndex, searchValue, this.filter.naStanju, this.filter.proizvodjacId)
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
    this.openKorpaSnackBar(snackBarPoruka);
    this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
  }

  openKorpaSnackBar(poruka: string) {
    this.korpaSnackBar.open(poruka, '', {
      duration: 2000,
    });
  }

  uKorpi(katBr: string) {
    return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
  }
}
