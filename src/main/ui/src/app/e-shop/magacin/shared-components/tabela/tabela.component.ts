import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Roba, Partner } from 'src/app/e-shop/model/dto';
import { LoginService } from 'src/app/e-shop/service/login.service';
import { AppUtilsService } from 'src/app/e-shop/utils/app-utils.service';
import { NotifikacijaService } from 'src/app/shared/service/notifikacija.service';
import { MatSnackBarKlase } from 'src/app/shared/model/konstante';
import { DataService } from 'src/app/e-shop/service/data/data.service';
import { Korpa } from 'src/app/e-shop/model/porudzbenica';

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

  public partner: Partner;
  private korpa: Korpa;

  // Tabela
  private columnDefinitions = [
    { def: 'katbr', ifNotAuth: true },
    { def: 'katbrpro', ifNotAuth: true },
    { def: 'proizvodjac', ifNotAuth: true },
    { def: 'naziv', ifNotAuth: true },
    { def: 'rabat', ifNotAuth: false },
    { def: 'cena', ifNotAuth: true },
    { def: 'stanje', ifNotAuth: true },
    { def: 'kolicina', ifNotAuth: false },
    { def: 'korpa', ifNotAuth: false },
    { def: 'u-korpi', ifNotAuth: false },
  ];

  constructor(
    private utilsService: AppUtilsService,
    private loginServis: LoginService,
    private notifikacijaServis: NotifikacijaService,
    private dataService: DataService
  ) { }

  ngOnInit() {
    this.dataService.trenutnaKorpa.subscribe(korpa => this.korpa = korpa);
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
  }

  paginatorEvent(pageEvent) {
    this.magacinEvent.emit(pageEvent);
  }

  getDisplayedColumns(): string[] {
    const isPartner = this.partner.ppid != null;
    const dataColumns = this.columnDefinitions
      .filter(cd => isPartner || cd.ifNotAuth)
      .map(cd => cd.def);
    return dataColumns;
  }

  dodajUKorpu(roba: Roba) {
    const snackBarPoruka = this.utilsService.dodajUKorpu(roba);
    this.notifikacijaServis.notify(snackBarPoruka, MatSnackBarKlase.Zelena);
    this.utilsService.izbrisiRobuSaStanja(this.roba, roba);
  }

  uKorpi(katBr: string): boolean {
    return this.utilsService.daLiJeRobaUKorpi(this.korpa, katBr);
  }
}
