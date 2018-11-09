import { Component, OnInit } from '@angular/core';
import { RobaService } from '../service/roba.service';
import { Roba } from '../model/roba';
import { takeWhile } from 'rxjs/operators';
import { LoadingData } from '../model/loading';
import { Sort, MatSnackBar } from '@angular/material';
import { Proizvodjac } from '../model/proizvodjac';
import { ProizvodjacService } from '../service/proizvodjac.service';
import { DataService } from '../service/data.service';
import { Korpa, RobaKorpa } from '../model/porudzbenica';
import { AppUtilsService } from '../utils/app-utils.service';

@Component({
  selector: 'app-roba',
  templateUrl: './roba.component.html',
  styleUrls: ['./roba.component.css']
})
export class RobaComponent implements OnInit {

  public roba: Roba[];
  public proizvodjaci: Proizvodjac[];

  // Paging and Sorting elements
  public rowsPerPage = 10;
  public pageIndex = 0;
  public sort = null;
  public tableLength;

  // Filteri
  public izabraniProizvodjac = '';
  public raspolozivost: string[] = ['Svi artikli', 'Ima na stanju'];
  public izabranaRaspolozivost: string = this.raspolozivost[1];

  public searchValue = '';
  public lastSearchValue = '';
  public pocetnoPretrazivanje: boolean;

  public ucitavanje = false;
  public otvoriFilterDiv = false;
  public displayedColumns: string[] = ['katbr', 'katbrpro', 'naziv'
    , 'proizvodjac', 'cena', 'stanje', 'kolicina', 'korpa', 'u-korpi'];
  public dataSource: any;

  private alive = true;
  private korpa: Korpa;

  constructor(private robaService: RobaService,
    private proizvodjacService: ProizvodjacService,
    private dataService: DataService,
    private utilsService: AppUtilsService,
    public korpaSnackBar: MatSnackBar
    ) { }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
    this.dataService.trenutnaKorpa.subscribe(korpa => this.korpa = korpa);
    this.pronadjiSveProizvodjace();
  }

  pronadjiSvuRobu() {
    this.robaService.pronadjiSvuRobu(this.sort, this.rowsPerPage, this.pageIndex, null, null, null)
      .pipe(takeWhile(() => this.alive))
      .subscribe(
        res => {
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
    this.ucitavanje = true;
    this.dataSource = null;
    const naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
    const proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
    this.robaService.pronadjiSvuRobu(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId)
      .pipe(takeWhile(() => this.alive))
      .subscribe(
        res => {
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

  pronadjiSveProizvodjace() {
    this.proizvodjacService.pronadjiSveProizvodjace()
      .pipe(takeWhile(() => this.alive))
      .subscribe(res => {
        this.proizvodjaci = res;
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.pronadjiSvuRobu();
      },
        error => {
          this.proizvodjaci = null;
          console.log('Pronaci svu robu je bacilo gresku', error);
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
    this.otvoriFilterDiv = !this.otvoriFilterDiv;
  }

  resetujFilter() {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    this.izabranaRaspolozivost = this.raspolozivost[1];
    this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
    this.filtriraj();
  }

  filtriraj() {
    if (this.dataSource) {
      this.pageIndex = 0;
    }
    let recZaPretragu: string;
    recZaPretragu = this.searchValue;
    this.pronadjiSvuRobuPoPretrazi(recZaPretragu);
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
