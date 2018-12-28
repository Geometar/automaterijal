import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RobaService } from 'src/app/service/roba.service';
import { Roba, Proizvodjac, Partner } from 'src/app/model/dto';
import { Korpa } from 'src/app/model/porudzbenica';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { DataService } from 'src/app/service/data/data.service';
import { ProizvodjacService } from 'src/app/service/proizvodjac.service';
import { AppUtilsService } from 'src/app/utils/app-utils.service';
import { LoginService } from 'src/app/service/login.service';
import { MatSnackBar, Sort } from '@angular/material';

@Component({
  selector: 'app-kategorija-specificna',
  templateUrl: './kategorija-specificna.component.html',
  styleUrls: ['./kategorija-specificna.component.scss']
})
export class KategorijaSpecificnaComponent implements OnInit {

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
  public pronadjenaRoba = true;
  public otvoriFilterDiv = false;

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
    private proizvodjacService: ProizvodjacService,
    private loginServis: LoginService,
    private utilsService: AppUtilsService,
    private dataService: DataService,
    private robaServis: RobaService,
    public korpaSnackBar: MatSnackBar,
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
    this.pronadjiSveProizvodjace();
  }

  pronadjiSveProizvodjace() {
    this.route.params.subscribe((params: Params) => {
    this.proizvodjacService.pronadjiSveProizvodjaceKategorije(params.id)
      .pipe(takeWhile(() => this.alive))
      .subscribe(res => {
        this.proizvodjaci = res;
        this.izabraniProizvodjac = this.proizvodjaci[0].naziv;
        this.pronandjiRobu();
      },
        error => {
          this.proizvodjaci = null;
          console.log('Pronaci svu robu je bacilo gresku', error);
        });
      });
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
    const naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.izabranaRaspolozivost);
    const proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.izabraniProizvodjac, this.proizvodjaci);
    this.ucitavanje = true;
    this.pronadjenaRoba = true;
    this.route.params.subscribe((params: Params) => {
      this.robaServis.pronadjiPoKategoriji(this.sort, this.rowsPerPage, this.pageIndex, searchValue, naStanju, proizvodjacId, params.id)
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

  idiNazad() {
    this.router.navigate(['/ostalo']);
  }
}
