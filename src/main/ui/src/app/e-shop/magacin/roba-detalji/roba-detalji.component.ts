import { Component, OnInit } from '@angular/core';
import { RobaService } from '../../service/roba.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Roba } from '../../model/dto';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { LoginService } from '../../service/login.service';
import { DataService } from '../../service/data/data.service';
import { AppUtilsService } from '../../utils/app-utils.service';
import { NotifikacijaService } from 'src/app/shared/service/notifikacija.service';
import { MatSnackBarKlase } from 'src/app/shared/model/konstante';
import { ArrayDataSource } from '@angular/cdk/collections';
import { P } from '@angular/core/src/render3';

@Component({
  selector: 'app-roba-detalji',
  templateUrl: './roba-detalji.component.html',
  styleUrls: ['./roba-detalji.component.scss']
})
export class RobaDetaljiComponent implements OnInit {

  public robaDetalji: Roba;
  public kljuceviAplikacija: string[] = [];

  public ucitavanje = false;
  public partnerLogovan = false;
  private alive = true;

  constructor(
    private robaService: RobaService,
    private dataService: DataService,
    private utilsService: AppUtilsService,
    private notifikacijaServis: NotifikacijaService,
    private loginServis: LoginService,
    private router: Router,
    private route: ActivatedRoute
    ) { }

  ngOnInit() {
    this.loginServis.daLiJePartnerUlogovan.subscribe(bool => this.partnerLogovan = bool);
    this.uzmiDetaljeRobe();
  }

  uzmiDetaljeRobe() {
    this.ucitavanje = true;
    this.route.params.subscribe((params: Params) => {
      this.robaService.pronadjiDetaljeRobe(params.id)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 404) {
            console.log('404 vratili detalji');
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false))
      .subscribe((res: HttpResponse<Roba>) => {
        this.robaDetalji = res.body;
        this.robaDetalji = this.dataService.skiniSaStanjaUkolikoJeUKorpi([this.robaDetalji])[0];
        this.popuniAplikacije();
        console.log(this.robaDetalji);
      });
    });
  }

  dodajKolicini(roba: Roba) {
    if (!Number(roba.kolicina)) {
      roba.kolicina = 1;
    }
    if (roba.kolicina < roba.stanje) {
      roba.kolicina = roba.kolicina + 1;
    }
  }
  oduzmiOdKolicine(roba: Roba) {
    if (!Number(roba.kolicina)) {
      roba.kolicina = 1;
    }
    if (roba.kolicina > 1) {
      roba.kolicina = roba.kolicina - 1;
    }
  }

  dodajUKorpu(roba: Roba) {
    this.loginServis.vratiUlogovanogKorisnika(false).subscribe(partner => {
      if (partner) {
        const snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.notifikacijaServis.notify(snackBarPoruka, MatSnackBarKlase.Zelena);
        this.utilsService.izbrisiRobuSaStanja([this.robaDetalji], roba);
      } else {
        this.router.navigate(['/login']);
        this.loginServis.izbaciPartnerIzSesije();
      }
    });
  }

  popuniAplikacije() {
    if (this.robaDetalji.aplikacije != null) {
      for (const key of Object.keys(this.robaDetalji.aplikacije)) {
        this.kljuceviAplikacija.push(key);
      }
      console.log(this.kljuceviAplikacija);
    }
  }
  vratiModelePoAutomobilu(automobil: string) {
    const a = this.robaDetalji.aplikacije[automobil];
    console.log(a);
    return this.robaDetalji.aplikacije[automobil];
  }
}
