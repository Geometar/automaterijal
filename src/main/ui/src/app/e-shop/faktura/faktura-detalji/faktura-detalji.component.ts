import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Partner, FakturaDetalji, Fakutra } from '../../model/dto';
import { LoginService } from '../../service/login.service';
import { FakturaService } from '../../service/faktura.service';

@Component({
  selector: 'app-faktura-detalji',
  templateUrl: './faktura-detalji.component.html',
  styleUrls: ['./faktura-detalji.component.scss']
})
export class FakturaDetaljiComponent implements OnInit {

  public partner: Partner;
  public faktura: Fakutra = new Fakutra();
  public fakturaDetalji: FakturaDetalji[];
  public dataSource: any;

  public error = false;

  // Paging and Sorting elements
  public rowsPerPage = 10;
  public pageIndex = 0;

  public displayedColumns: string[] = ['robaId', 'proizvodjac', 'kolicina', 'potvrdjenaKolicina'
  , 'rabat', 'cena', 'status'];

  constructor(
    private loginServis: LoginService,
    private route: ActivatedRoute,
    private fakturaServis: FakturaService,
    private router: Router) { }

  ngOnInit() {
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.route.params.subscribe((params: Params) => {
      this.fakturaServis.vratiFakturuPojedinacno(params.id, this.partner.ppid)
        .subscribe((res: Fakutra) => {
          this.error = false;
          this.faktura = res;
          this.fakturaDetalji = res.detalji;
          this.dataSource = this.fakturaDetalji;
        },
          error => {
            this.error = true;
            console.log('Pronaci detalje fakture je bacilo gresku', error);
          });
    });
  }

  idiNazad() {
    this.router.navigate(['/porudzbenice']);
  }

}