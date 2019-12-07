import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ProizvodjacService } from 'src/app/e-shop/service/proizvodjac.service';
import { takeWhile } from 'rxjs/operators';
import { VrstaRobe } from 'src/app/e-shop/model/roba.enum';
import { Filter } from 'src/app/e-shop/model/filter';
import { AppUtilsService } from 'src/app/e-shop/utils/app-utils.service';
import { Observable } from 'rxjs';
import { ActivatedRoute, Params } from '@angular/router';
import { Proizvodjac } from 'src/app/e-shop/model/dto';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.scss']
})
export class FilterComponent implements OnInit {

  @Input() otvoriFilter;
  @Input() vrstaRobe;
  @Input() vrstaUlja;
  @Input() industrijkoUljeEvent: Observable<string>;
  @Output() filterEvent = new EventEmitter<any>();

  public proizvodjaci: Proizvodjac[];

  public filter = new Filter();

  public raspolozivost: string[] = ['Svi artikli', 'Ima na stanju'];

  private alive = true;

  constructor(
    private route: ActivatedRoute,
    private proizvodjacService: ProizvodjacService,
    private utilsService: AppUtilsService) { }

  ngOnInit() {
    if (this.industrijkoUljeEvent) {
      this.industrijkoUljeEvent.subscribe((vrstaUlja: string) => {
        this.vrstaUlja = vrstaUlja;
      });
    }
    this.filter.raspolozivost = this.raspolozivost[0];
    this.pronadjiProizvodjace();
  }

  pronadjiProizvodjace() {
    if (this.vrstaRobe === VrstaRobe.AKUMULATORI) {
      this.proizvodjacService.pronadjiSveProizvodjaceAkumulatora()
        .pipe(takeWhile(() => this.alive))
        .subscribe(res => {
          this.proizvodjaci = res;
          this.filter.proizvodjac = this.proizvodjaci[0].naziv;
        },
          error => {
            this.proizvodjaci = null;
          });
    } else if (this.vrstaRobe === VrstaRobe.FILTERI) {
      this.proizvodjacService.pronadjiSveProizvodjaceFiltera()
        .pipe(takeWhile(() => this.alive))
        .subscribe(res => {
          this.proizvodjaci = res;
          this.filter.proizvodjac = this.proizvodjaci[0].naziv;
        },
          error => {
            this.proizvodjaci = null;
          });
    } else if (this.vrstaRobe === VrstaRobe.SVE) {
      this.proizvodjacService.pronadjiSveProizvodjace()
        .pipe(takeWhile(() => this.alive))
        .subscribe(res => {
          this.proizvodjaci = res;
          this.filter.proizvodjac = this.proizvodjaci[0].naziv;
        },
          error => {
            this.proizvodjaci = null;
          });
    } else if (this.vrstaRobe === VrstaRobe.ULJA) {
      this.proizvodjacService.pronadjiSveProizvodjaceUljaPoVrsti(this.vrstaUlja)
        .pipe(takeWhile(() => this.alive))
        .subscribe(res => {
          this.proizvodjaci = res;
          this.filter.proizvodjac = this.proizvodjaci[0].naziv;
        },
          error => {
            this.proizvodjaci = null;
          });
    } else if (this.vrstaRobe === VrstaRobe.OSTALO) {
      this.route.params.subscribe((params: Params) => {
        this.proizvodjacService.pronadjiSveProizvodjaceKategorije(params.id)
          .pipe(takeWhile(() => this.alive))
          .subscribe(res => {
            this.proizvodjaci = res;
            this.filter.proizvodjac = this.proizvodjaci[0].naziv;
          },
            error => {
              this.proizvodjaci = null;
            });
      });
    }
  }

  filtriraj() {
    this.filter.naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.filter.raspolozivost);
    this.filter.proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.filter.proizvodjac, this.proizvodjaci);
    this.filterEvent.emit(this.filter);
  }

  resetujFilter() {
    this.filter.raspolozivost = this.raspolozivost[1];
    this.filter.proizvodjac = this.proizvodjaci[0].naziv;
    this.filter.naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.filter.raspolozivost);
    this.filter.proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.filter.proizvodjac, this.proizvodjaci);

    this.filterEvent.emit(this.filter);
  }
}
