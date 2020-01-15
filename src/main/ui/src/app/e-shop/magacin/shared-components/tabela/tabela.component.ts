import { Component, OnInit, Input, Output, EventEmitter, HostListener } from '@angular/core';
import { Roba } from 'src/app/e-shop/model/dto';
import { LoginService } from 'src/app/e-shop/service/login.service';
import { AppUtilsService } from 'src/app/e-shop/utils/app-utils.service';
import { NotifikacijaService } from 'src/app/shared/service/notifikacija.service';
import { MatSnackBarKlase } from 'src/app/shared/model/konstante';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { Korpa } from 'src/app/e-shop/model/porudzbenica';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tabela',
  templateUrl: './tabela.component.html',
  styleUrls: ['./tabela.component.scss']
})
export class TabelaComponent implements OnInit {

  @Input() dataSource: any[];
  @Input() roba: Roba[];

  // Paging and Sorting elements
  @Input() rowsPerPage = 10;
  @Input() pageIndex = 0;
  @Input() tableLength;
  @Output() magacinEvent = new EventEmitter<any>();

  innerWidth;
  public partnerLogovan = false;
  private korpa: Korpa;
  public jeMobilni = window.innerWidth > 900;

  // Tabela
  private columnDefinitions = [
    { def: 'slika', ifNotMobile: true },
    { def: 'opis', ifNotMobile: true },
    { def: 'tehnickidetalji', ifNotAuth: false },
    { def: 'korpa', ifNotMobile: true },
  ];

  constructor(
    private utilsService: AppUtilsService,
    private loginServis: LoginService,
    private notifikacijaServis: NotifikacijaService,
    private dataService: DataService,
    private router: Router
  ) { }

  ngOnInit() {
    this.dataService.trenutnaKorpa.subscribe(korpa => this.korpa = korpa);
    this.loginServis.daLiJePartnerUlogovan.subscribe(bool => this.partnerLogovan = bool);
    this.innerWidth = window.innerWidth;
    this.changeSlideConfiguration();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
    this.changeSlideConfiguration();
  }

  changeSlideConfiguration() {
    if (this.innerWidth < 900) {
      this.jeMobilni = false;
    } else {
      this.jeMobilni = true;
    }
  }

  paginatorEvent(pageEvent) {
    this.magacinEvent.emit(pageEvent);
    window.scroll(0, 0);
  }

  getDisplayedColumns(): string[] {
    const dataColumns = this.columnDefinitions
      .filter(cd => this.jeMobilni || cd.ifNotMobile)
      .map(cd => cd.def);
    return dataColumns;
  }

  dodajUKorpu(roba: Roba) {
    this.loginServis.vratiUlogovanogKorisnika(false).subscribe(partner => {
      if (partner) {
        const snackBarPoruka = this.utilsService.dodajUKorpu(roba);
        this.notifikacijaServis.notify(snackBarPoruka, MatSnackBarKlase.Zelena);
        this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
      } else {
        this.router.navigate(['/login']);
        this.loginServis.izbaciPartnerIzSesije();
      }
    });
  }

  uKorpi(katBr: string): boolean {
    return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
  }
}
