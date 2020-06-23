import { OnInit, Component, OnDestroy } from '@angular/core';
import { DashboardService } from 'src/app/e-shop/service/dashboard.service';
import { takeWhile } from 'rxjs/operators';
import { Dashboard, Roba } from 'src/app/e-shop/model/dto';
import { AppUtilsService } from 'src/app/e-shop/utils/app-utils.service';
import { LoginService } from 'src/app/e-shop/service/login.service';
import { NotifikacijaService } from 'src/app/shared/service/notifikacija.service';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { Router } from '@angular/router';
import { MatSnackBarKlase } from 'src/app/shared/model/konstante';
import { Korpa } from 'src/app/e-shop/model/porudzbenica';

@Component({
  selector: 'app-dasboard',
  templateUrl: './dasboard.component.html',
  styleUrls: ['./dasboard.component.scss']
})
export class DasboardComponent implements OnInit, OnDestroy {

  // boolean za unistavanje observera
  private alive = true;

  public brojArtikala: any = '-';
  public brojProizvodjaca: any = '-';
  public brojFakture: any = '-';
  public robaPonuda: Roba[] = [];
  public ponudaRobaId: number[] = [25622, 109941, 128165, 25623, 25624];

  constructor(private servis: DashboardService,
    private utilsService: AppUtilsService,
    private notifikacijaServis: NotifikacijaService,
    private dataService: DataService,
    private router: Router) { }

  ngOnInit() {
    this.inicijalniPodaci();
    this.izdvajamoIzPonude();
  }

  inicijalniPodaci() {
    this.servis.vratiOsnovnePodatke()
      .pipe(takeWhile(() => this.alive))
      .subscribe((podaci: Dashboard) => {
        this.brojArtikala = podaci.brojArtikala;
        this.brojProizvodjaca = podaci.brojProizvodjaca;
        this.brojFakture = podaci.brojFaktura;
      });
  }

  izdvajamoIzPonude() {
    this.servis.vratiORobuIzdvojenuIzPonude(this.ponudaRobaId)
      .pipe(takeWhile(() => this.alive))
      .subscribe((roba: Roba[]) => {
        this.robaPonuda = this.dataService.skiniSaStanjaUkolikoJeUKorpi(roba);
      });
  }

  detaljiRobe(robaId: string) {
    const url = this.router.parseUrl(this.router.url);
    this.router.navigate(['/roba/' + robaId], { queryParams: { prosliUrl: url.root.children.primary.segments[0].path } });
  }

  dodajUKorpu(roba: Roba) {
    const snackBarPoruka = this.utilsService.dodajUKorpu(roba);
    this.notifikacijaServis.notify(snackBarPoruka, MatSnackBarKlase.Zelena);
    this.utilsService.izbrisiRobuSaStanja(this.robaPonuda, roba);
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

  ngOnDestroy() {
    this.alive = false;
  }
}
