import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { Roba } from 'src/app/e-shop/model/dto';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { RobaService } from 'src/app/e-shop/service/roba.service';
import { VrstaRobe } from 'src/app/e-shop/model/roba.enum';
import { Filter } from 'src/app/e-shop/model/filter';

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
  public dataSource: any;

  private alive = true;

  constructor(
    private route: ActivatedRoute,
    private dataService: DataService,
    private robaServis: RobaService,
    private router: Router
  ) { }

  ngOnInit() {
    this.pocetnoPretrazivanje = true;
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
            this.roba = this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
            this.dataSource = this.roba;
            this.rowsPerPage = res.size;
            this.pageIndex = res.number;
            this.tableLength = res.totalElements;
          },
          error => {
            this.roba = null;
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
            this.roba = this.dataService.skiniSaStanjaUkolikoJeUKorpi(this.roba);
            this.dataSource = this.roba;
            this.rowsPerPage = res.size;
            this.pageIndex = res.number;
            this.tableLength = res.totalElements;
          },
          error => {
            this.roba = null;
          });
    });
  }
  paginatorEvent(pageEvent) {
    this.dataSource = [];
    this.rowsPerPage = pageEvent.pageSize;
    this.pageIndex = pageEvent.pageIndex;
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

  idiNazad() {
    this.router.navigate(['/ostalo']);
  }
}
