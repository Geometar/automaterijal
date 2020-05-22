import { Component, OnInit, HostListener } from '@angular/core';
import { RobaService } from '../../service/roba.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Roba, RobaBrojevi, Partner } from '../../model/dto';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { LoginService } from '../../service/login.service';
import { DataService } from '../../service/data/data.service';
import { AppUtilsService } from '../../utils/app-utils.service';
import { NotifikacijaService } from 'src/app/shared/service/notifikacija.service';
import { MatSnackBarKlase } from 'src/app/shared/model/konstante';
import { Location } from '@angular/common';
import { Korpa } from 'src/app/e-shop/model/porudzbenica';

@Component({
  selector: 'app-roba-detalji',
  templateUrl: './roba-detalji.component.html',
  styleUrls: ['./roba-detalji.component.scss']
})
export class RobaDetaljiComponent implements OnInit {

  public robaDetalji: Roba;
  public kljuceviAplikacija: string[] = [];
  public kluceviRobe: string[] = [];
  public originalniBrojevi: OeBrojevi[];
  public partner: Partner;

  private korpa: Korpa;
  public ucitavanje = false;
  public partnerLogovan = false;
  private alive = true;

  public editTekst = false;

  innerWidth;
  public velikiEkran = window.innerWidth > 650;

  constructor(
    private robaService: RobaService,
    private dataService: DataService,
    private utilsService: AppUtilsService,
    private notifikacijaServis: NotifikacijaService,
    private loginServis: LoginService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.dataService.trenutnaKorpa.subscribe(korpa => this.korpa = korpa);
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.loginServis.daLiJePartnerUlogovan.subscribe(bool => this.partnerLogovan = bool);
    this.uzmiDetaljeRobe();
    this.promeniTabeluDetaljaAutomobila();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
    this.promeniTabeluDetaljaAutomobila();
  }

  promeniTabeluDetaljaAutomobila() {
    if (this.innerWidth > 650) {
      this.velikiEkran = true;
    } else {
      this.velikiEkran = false;
    }
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
          this.popuniOeBrojeve();
          console.log(this.robaDetalji);
        });
    });
  }

  sacuvajTekst() {
    this.editTekst = false;
    this.robaService.sacuvajTekst(this.robaDetalji)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 403) {
            this.router.navigate(['/login']);
            this.loginServis.izbaciPartnerIzSesije();
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false))
      .subscribe((res: HttpResponse<Roba>) => {
        this.notifikacijaServis.notify('Uspesno izmenjen opis', MatSnackBarKlase.Plava);
      });
  }

  dodajKolicini(roba: Roba) {
    if (!Number(roba.kolicina)) {
      roba.kolicina = 1;
    }
    if (roba.kolicina < roba.stanje) {
      roba.kolicina = roba.kolicina + 1;
    } else {
      this.notifikacijaServis.notify('Maksimalna količina dostignuta', MatSnackBarKlase.Plava);
    }
  }
  oduzmiOdKolicine(roba: Roba) {
    if (!Number(roba.kolicina)) {
      roba.kolicina = 1;
    }
    if (roba.kolicina > 1) {
      roba.kolicina = roba.kolicina - 1;
    } else {
      this.notifikacijaServis.notify('Količina ne može biti negativna', MatSnackBarKlase.Plava);
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
    }
  }

  popuniOeBrojeve() {
    if (this.robaDetalji.tdBrojevi != null) {
      for (const key of Object.keys(this.robaDetalji.tdBrojevi)) {
        this.kluceviRobe.push(key);
      }
    }
  }

  vratiModelePoAutomobilu(automobil: string) {
    return this.robaDetalji.aplikacije[automobil];
  }

  vratiOriginalneBrojevePoProizvodjacu(proizvodjac: string) {
    return this.robaDetalji.tdBrojevi[proizvodjac];
  }

  idiNazad() {
    this.location.back();
  }

  uKorpi(katBr: string): boolean {
    return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
  }

  traziPoBroju(katBr) {
    this.route.queryParams.subscribe(params => {
      const url = '/' + params['prosliUrl'] + '/';
      this.router.navigate([url], { queryParams: { pretraga: katBr } });
    });
  }

}
class OeBrojevi {
  broj: string;
  proizvodjac: string;
  constructor(broj, proizvodjac) {
    this.broj = broj;
    this.proizvodjac = proizvodjac;
  }
}
