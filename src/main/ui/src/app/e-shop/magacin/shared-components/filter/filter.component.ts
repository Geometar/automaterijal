import { Component, OnInit, Input, Output, EventEmitter, SimpleChanges } from '@angular/core';
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

  @Input() vrstaRobe;
  @Input() vrstaUlja;
  @Input() filterGrupe;
  @Input() proizvodjaci;
  @Input() industrijkoUljeEvent: Observable<string>;
  @Input() filter: Filter;
  @Output() filterEvent = new EventEmitter<any>();

  public raspolozivost: string[] = ['Svi artikli', 'Ima na stanju'];

  private alive = true;

  constructor(
    private utilsService: AppUtilsService) { }

  ngOnChanges(changes: SimpleChanges) {
    changes.proizvodjaci.currentValue.forEach((proizvodjac: Proizvodjac) => {
      if (proizvodjac.proid === this.filter.proizvodjacId) {
        this.filter.proizvodjac = proizvodjac.naziv;
      }
    });
    if (this.filter) {
      if (!this.filter.grupa) {
        this.filter.grupa = 'Sve grupe';
      }
      if (!this.filter.proizvodjacId) {
        this.filter.proizvodjac = 'Svi proizvodjači';
      }
      if (!this.filter.naStanju) {
        this.filter.raspolozivost = this.raspolozivost[0];
      }
    }
  }

  ngOnInit() {
    if (this.industrijkoUljeEvent) {
      this.industrijkoUljeEvent.subscribe((vrstaUlja: string) => {
        this.vrstaUlja = vrstaUlja;
      });
    }

    if (this.filter) {
      if (this.filter.naStanju) {
        this.filter.raspolozivost = this.raspolozivost[1];
        if (!this.filter.proizvodjac) {
          this.filter.proizvodjac = 'Svi proizvodjači';
        }
        if (!this.filter.grupa) {
          this.filter.grupa = 'Sve grupe';
        }
      } else {
        if (!this.filter.proizvodjac) {
          this.filter.proizvodjac = 'Svi proizvodjači';
        }
        if (!this.filter.grupa) {
          this.filter.grupa = 'Sve grupe';
        }
        this.filter.raspolozivost = this.raspolozivost[0];
      }
    } else {
      this.filter = new Filter();
      this.filter.raspolozivost = this.raspolozivost[0];
      this.filter.proizvodjac = 'Svi proizvodjači';
      this.filter.grupa = 'Sve grupe';
    }
  }

  proizvodjacVecIzabran() {
    this.proizvodjaci.forEach((proizvodjac: Proizvodjac) => {
      if (proizvodjac.proid === this.filter.proizvodjacId) {
        this.filter.proizvodjac = proizvodjac.naziv;
        return;
      }
    });
  }

  filtriraj() {
    this.filter.naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.filter.raspolozivost);
    this.filter.proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.filter.proizvodjac, this.proizvodjaci);
    this.filterEvent.emit(this.filter);
  }

  resetujFilter() {
    this.filter.raspolozivost = this.raspolozivost[0];
    this.filter.proizvodjac = this.proizvodjaci[0].naziv;
    this.filter.naStanju = this.utilsService.daLiRobaTrebaDaBudeNaStanju(this.raspolozivost, this.filter.raspolozivost);
    this.filter.proizvodjacId = this.utilsService.vratiIdProizvodjacaAkoPostoji(this.filter.proizvodjac, this.proizvodjaci);

    this.filterEvent.emit(this.filter);
  }
}
