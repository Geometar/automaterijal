import { Component, OnInit } from '@angular/core';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Roba } from '../../model/dto';
import { Korpa } from '../../model/porudzbenica';
import { RobaService } from '../../service/roba.service';
import { AppUtilsService } from '../../utils/app-utils.service';
import { DataService } from '../../service/data/data.service';
import { VrstaRobe } from '../../model/roba.enum';
import { Filter } from '../../model/filter';
import { NotifikacijaService } from 'src/app/shared/service/notifikacija.service';

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
  public dataSource: any;

  private alive = true;
  private korpa: Korpa;

  constructor(
    private robaService: RobaService,
    private utilsService: AppUtilsService,
    private dataService: DataService,
    private notifikacijaServis: NotifikacijaService) { }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
    this.dataService.trenutnaKorpa.subscribe(korpa => this.korpa = korpa);
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

  uKorpi(katBr: string) {
    return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
  }
}